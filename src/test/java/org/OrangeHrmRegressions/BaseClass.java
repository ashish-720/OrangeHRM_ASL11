package org.OrangeHrmRegressions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    WebDriver driver;

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

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
