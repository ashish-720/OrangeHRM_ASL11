package org.OrangeHrmRegressions;

import org.OrangeHRMModules.TopBarModule;
import org.OrangeHRMPages.DashBoardPage;
import org.OrangeHRMPages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrangeHRMSmoke extends BaseClass {


    @Parameters({"url"})
    @Test(priority = 1)
    public void navigateToApp(@Optional("https://ashish720-trials821.orangehrmlive.com") String url) {
        driver.get(url);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.atLoginPage();
    }

    @Parameters({"username", "password"})
    @Test(priority = 2)
    public void login(@Optional("admin") String username, @Optional("CxOJz@H1c6") String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        dashBoardPage.atDashBoard();
        String currentProfile = dashBoardPage.leftMenuModule.profileModule.getProfileName();
        Assert.assertEquals(currentProfile, "Aaron Hamilton", "Verifying Current HR");
    }

    @Test(priority = 3)
    public void logout() {
        TopBarModule topBarModule = new TopBarModule(driver);
        topBarModule.logoutUsingOptionsMenuItem("Logout from all browsers");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.atLoginPage();
    }

}
