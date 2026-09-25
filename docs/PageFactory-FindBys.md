# PageFactory: `@FindBy`, `@FindBys` and `@FindAll`

Reference notes for the PageFactory locator annotations used in this project. First written for `ProfileModule.profileName` (`src/main/java/org/OrangeHRMModules/ProfileModule.java`).

---

## `@FindBys` means a chained lookup, not a list

The name suggests a list, but `@FindBys` actually does a **chained (nested) lookup**. Whether you get one element or many depends on the **field type**, not on the annotation.

```java
@FindBys({
        @FindBy(id = "sidebar-profile-picture"),   // step 1: find this element
        @FindBy(className = "name")                // step 2: search INSIDE it for class="name"
})
private WebElement profileName;
```

Each `@FindBy` runs in order, and each step searches **within the result of the previous step**. The code above does the same as:

```java
driver.findElement(By.id("sidebar-profile-picture"))
      .findElement(By.className("name"));
```

Internally, Selenium turns this into a `ByChained` locator.

---

## Single element vs. list

Field type

Behaviour

`WebElement`

Returns the **first** match of the chain. Throws `NoSuchElementException` if nothing matches.

`List<WebElement>`

Returns **all** matches of the chain. Returns an empty list if nothing matches.

```java
// All ".name" elements nested under #sidebar-profile-picture
@FindBys({
        @FindBy(id = "sidebar-profile-picture"),
        @FindBy(className = "name")
})
private List<WebElement> profileNames;
```

---

## The three annotations compared

Annotation

Logic

Meaning

`@FindBy`

One locator

Finds by a single strategy (`id`, `css`, `xpath`, ...).

`@FindBys`

**AND** (parent -> child)

Each locator searches inside the previous result. The element must match the whole chain.

`@FindAll`

**OR**

Returns elements that match **any** of the locators. Usually paired with `List<WebElement>`.

```java
// @FindAll: elements with class "name" OR class "job-title"
@FindAll({
        @FindBy(className = "name"),
        @FindBy(className = "job-title")
})
private List<WebElement> profileTexts;
```

---

## Things to watch for

### 1. `@FindBys` searches only descendants

Step 2 searches only **descendants** of the step 1 element. If the target is a **sibling** (or sits somewhere else in the DOM), the chain fails. In that case, use one locator that describes the real relationship:

```java
@FindBy(css = "#sidebar-profile-picture .name")                                   // descendant
@FindBy(xpath = "//*[@id='sidebar-profile-picture']/following-sibling::*[@class='name']") // sibling
```

### 2. XPath starting with `//` ignores the parent element

When you call `findElement` on a **WebElement**, an XPath that starts with `//` still searches the **whole document**, not just that element. To stay inside the element, prefix it with `.`:

```java
parent.findElement(By.xpath("//a"));   // searches the entire page
parent.findElement(By.xpath(".//a"));  // searches only inside parent
```

CSS selectors and `By.id` / `By.className` are always relative to the parent element.

### 3. Lazy proxies

PageFactory fields are **proxies**. The lookup doesn't happen when the page object is created; it runs **every time** a method is called on the field. So a field can safely point to an element that appears later. Use `@CacheLookup` only for elements that never get re-rendered.