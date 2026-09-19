package org.OrangeHRMPages;

import org.OrangeHRMModules.LeftMenuModule;
import org.OrangeHRMModules.TopBarModule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoardPage extends BasePage {
    public LeftMenuModule leftMenuModule;
    public TopBarModule topBarModule;

    @FindBy(how = How.ID, using = "topbar-ribbon")
    private WebElement topBarRibbon;

    @FindBy(how = How.ID, using = "top-ribbon-menu")
    private WebElement topBarRibbonMenu;

    @FindBy(how = How.ID, using = "ribbon-actions")
    private WebElement topBarRibbonActions;

    @FindBy(how = How.CSS, using = "#ribbon-action-list help-button a")
    private WebElement helpActionButton;

    @FindBy(how = How.CSS, using = "#ribbon-action-list my-shortcut>div>a")
    private WebElement myShortCutActionButton;

    @FindBy(how = How.XPATH, using = "//div[@class='top-level-menu-item-container']")
    private WebElement topLevelMenuItemContainer;

    public WebElement getTopLevelMenuItemContainerItem(String menuItem) {
        return topLevelMenuItemContainer.findElement(By.xpath("a[contains(text(), " + menuItem + ")]"));
    }


    public DashBoardPage(WebDriver driver) {
        super(driver);
        leftMenuModule = new LeftMenuModule(driver);
        topBarModule = new TopBarModule(driver);
    }

    public void atDashBoard() {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(topBarModule.getTopBar()));
    }

    public void clickMenuItem(String menuItem) {
        getTopLevelMenuItemContainerItem(menuItem).click();
    }

}
