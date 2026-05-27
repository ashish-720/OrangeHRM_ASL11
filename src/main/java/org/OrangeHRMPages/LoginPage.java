package org.OrangeHRMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends BasePage {

    @FindBy(how = How.CLASS_NAME, using = "login-form-container")
    private WebElement loginForm;

    @FindBy(how = How.ID, using = "txtUsername")
    private WebElement usernameField;

    @FindBy(how = How.ID, using = "txtPassword")
    private WebElement passwordField;

    @FindBy(how = How.XPATH, using = "//img[@title='Show Password']")
    private WebElement showPasswordIcon;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
        Assert.assertTrue(usernameField.getAttribute("value").equals(username));
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        Assert.assertTrue(passwordField.getAttribute("value").equals(password));
    }

    public void atLoginPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(loginForm));
    }

    public void login(String username, String password) {
        atLoginPage();
        enterUsername(username);
        enterPassword(password);
        loginButton.click();
    }
}
