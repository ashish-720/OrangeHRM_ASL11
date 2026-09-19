package org.OrangeHRMModules;

import org.OrangeHRMPages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TopBarModule extends BasePage {

    @FindBy(how = How.ID, using = "topbar")
    private WebElement topBar;

    @FindBy(how = How.CLASS_NAME, using = "page-title tooltipped title1")
    private WebElement pageTitle;

    @FindBy(css = "#navbar-logout")
    private WebElement navBarLogout;

    public WebElement getPageTitle() {
        return pageTitle;
    }

    public WebElement getTopBar() {
        return topBar;
    }

    public TopBarModule(WebDriver driver) {
        super(driver);
    }

    public boolean verifyTitle(String title) {
        return getPageTitle().getText().equals(title);
    }

    public WebElement getLogOutButton(){
        return navBarLogout.findElement(By.xpath("./a"));
    }
}
