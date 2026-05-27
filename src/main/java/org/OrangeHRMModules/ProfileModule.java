package org.OrangeHRMModules;

import org.OrangeHRMPages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

public class ProfileModule extends BasePage {
    @FindBy(how = How.ID, using = "sidebar-profile-picture")
    private WebElement profileContainer;

    @FindBys({
            @FindBy(id = "sidebar-profile-picture"),
            @FindBy(className = "name")
    })
    private WebElement profileName;

    @FindBy(how = How.CLASS_NAME, using = "job-title")
    private WebElement jobTitle;

    public ProfileModule(WebDriver driver) {
        super(driver);
    }

    public WebElement getImageContainer() {
        return profileContainer.findElement(By.className("image-container"));
    }

    public WebElement getProfileSettings() {
        return profileContainer.findElement(By.xpath("//a[contains(@class,'profile-context-menu-handler')]/i"));
    }

    public String getProfileName() {
        return profileName.getText();
    }

    public String getJobTitle() {
        return jobTitle.getText();
    }
}
