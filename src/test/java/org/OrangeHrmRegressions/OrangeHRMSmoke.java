package org.OrangeHrmRegressions;

import org.OrangeHRMPages.DashBoardPage;
import org.OrangeHRMPages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrangeHRMSmoke extends BaseClass {


    @Parameters({"url"})
    @Test(priority = 1)
    public void navigateToApp(@Optional("https://ashish1993-trials80.orangehrmlive.com") String url) {
        driver.get(url);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.atLoginPage();
    }

    @Parameters({"username", "password"})
    @Test(priority = 2)
    public void login(@Optional("admin") String username, @Optional("Fr@Zue8O1T") String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        dashBoardPage.atDashBoard();
        String currentProfile = dashBoardPage.leftMenuModule.profileModule.getProfileName();
        Assert.assertEquals(currentProfile, "Aaron Hamilton", "Verifying Current HR");
    }

}
