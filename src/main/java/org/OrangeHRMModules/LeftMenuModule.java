package org.OrangeHRMModules;

import org.OrangeHRMPages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LeftMenuModule extends BasePage {
    public ProfileModule profileModule;

    @FindBy(how = How.CSS, using = "div#left-menu")
    private WebElement leftMenu;

    public LeftMenuModule(WebDriver driver) {
        super(driver);
        profileModule = new ProfileModule(driver);
    }


}
