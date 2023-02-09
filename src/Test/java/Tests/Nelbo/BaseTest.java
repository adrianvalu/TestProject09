package Tests.Nelbo;

import Pages.Nelbo.MainPage;
import Utils.BrowserUtils;
import Utils.ConstantUtils;
import Utils.ExtentTestManager;
import Utils.GenericUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    public WebDriver driver;
    String usedConfig = ConstantUtils.CONFIG_FILE;
    String baseUrl = GenericUtils.createBaseUrl(ConstantUtils.CONFIG_FILE);
    String dbHostname, dbUser, dbSchema, dbPassword, dbPort;
    Base64 base64 = new Base64();
    ExtentTest test;
    String browser;


    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        System.out.println(baseUrl);
        browser = System.getProperty("browser");
        if (browser == null)
            //default value
            browser = GenericUtils.getBrowserConfig(usedConfig);

        System.out.println("Used browser:" + browser);
        driver = BrowserUtils.getBrowser(browser,usedConfig);
        driver.manage().window().maximize();
        dbHostname = GenericUtils.getDBHostname(usedConfig);
        dbUser = GenericUtils.getDBUser(usedConfig);
        dbPassword = GenericUtils.getDBPassword(usedConfig);
        dbPort = GenericUtils.getDBPort(usedConfig);
        dbSchema = GenericUtils.getDBSchema(usedConfig);
    }

    @AfterMethod
    public void getResult(ITestResult result) {
        ExtentTestManager.updateTest(test, driver, result);
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        driver.quit();
        ExtentTestManager.extent.flush();
    }
}