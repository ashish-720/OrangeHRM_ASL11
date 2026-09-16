package org.OrangeHrmRegressions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    WebDriver driver;
    ExtentReports extentReports;
    ExtentTest test;

    @BeforeSuite
    public void configureExtentReport() {
        extentReports = new ExtentReports();
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("Orange_HRM_Smoke.html");
        extentReports.attachReporter(extentSparkReporter);
    }

    @Parameters({"browserName"})
    @BeforeTest
    public void launchBrowser(@Optional("chrome") String browserName) {
        switch (browserName) {
            case "chrome":
                WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeTest
    public void createExtentReportTest(ITestContext testContext) {
        test = extentReports.createTest(testContext.getName());
        test.assignAuthor(testContext.getCurrentXmlTest().getParameter("Author"));
        test.assignDevice(testContext.getCurrentXmlTest().getParameter("browserName"));
    }

    @AfterMethod
    public void createExtentTestLogs(Method method, ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS)
            test.log(Status.PASS, "Test Step '" + method.getName() + "' passed");
        else if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Step '" + method.getName() + "' failed");
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @AfterSuite
    public void generateExtentReport() {
        extentReports.flush();
        try {
            Desktop.getDesktop().browse(new File("Orange_HRM_Smoke.html").toURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
