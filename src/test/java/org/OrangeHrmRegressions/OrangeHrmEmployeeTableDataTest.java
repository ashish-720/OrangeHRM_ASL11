package org.OrangeHrmRegressions;

import org.OrangeHRMPages.DashBoardPage;
import org.OrangeHRMPages.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrangeHrmEmployeeTableDataTest extends BaseClass {

    private static final Logger log = LoggerFactory.getLogger(OrangeHrmEmployeeTableDataTest.class);

    @Parameters({"url"})
    @Test
    public void navigateToApp(@Optional("https://ashish1993-trials80.orangehrmlive.com") String url) {
        driver.get(url);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.atLoginPage();
    }

    @Parameters({"username", "password"})
    @Test
    public void loginToApp(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        dashBoardPage.atDashBoard();
        dashBoardPage.clickMenuItem("Employee List");
    }
}
