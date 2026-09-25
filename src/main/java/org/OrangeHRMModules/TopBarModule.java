package org.OrangeHRMModules;

import org.OrangeHRMPages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopBarModule extends BasePage {

    @FindBy(how = How.ID, using = "topbar")
    private WebElement topBar;

    @FindBy(how = How.CLASS_NAME, using = "page-title tooltipped title1")
    private WebElement pageTitle;

    @FindBy(css = "#navbar-logout")
    private WebElement navBarLogout;

    @FindBy(how = How.CSS, using = "#navbar-logout #logout-options-dropdown-button>i")
    private WebElement logOutOptionsDropDownButton;

    @FindBy(how = How.CSS, using = "#navbar-logout #logout-options-panel")
    private WebElement logOutOptionsPanel;

    @FindBy(how = How.CSS, using = "#navbar-logout .logout-options-menu-item")
    private WebElement logOutOptionsMenuItem;

    public WebElement getPageTitle() {
        return pageTitle;
    }

    public WebElement getTopBar() {
        return topBar;
    }

    public WebElement getNavBarLogout() {
        return navBarLogout;
    }

    public WebElement getLogOutOptionsDropDownButton() {
        return logOutOptionsDropDownButton;
    }

    public WebElement getLogOutOptionsPanel() {
        return logOutOptionsPanel;
    }

    public WebElement getLogOutOptionsMenuItem() {
        return logOutOptionsMenuItem;
    }

    public TopBarModule(WebDriver driver) {
        super(driver);
    }

    public boolean verifyTitle(String title) {
        return getPageTitle().getText().equals(title);
    }

    public WebElement getLogOutButton() {
        return navBarLogout.findElement(By.xpath("./a/span[text()='Log Out']"));
    }

    public void logoutUsingOptionsMenuItem(String option) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 3); //TODO create a wait class separately and use it
        logOutOptionsDropDownButton.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(logOutOptionsPanel));
        WebElement logOutOptionsMenuItemLink = logOutOptionsMenuItem.findElement(By.xpath("//a[text()='" + option + "']"));
        logOutOptionsMenuItemLink.click();
    }

    public void logOut() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 3);
        webDriverWait.until(ExpectedConditions.visibilityOf(getLogOutButton())).click();
    }
}
