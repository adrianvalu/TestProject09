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
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

public class BaseTest {

    public WebDriver driver;
    String browser = GenericUtils.getBrowserConfig(ConstantUtils.CONFIG_FILE);
    String baseUrl = GenericUtils.createBaseUrl(ConstantUtils.CONFIG_FILE);
    Base64 base64 = new Base64();
    ExtentTest test;


    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        driver = BrowserUtils.getBrowser(browser, ConstantUtils.CONFIG_FILE);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void getResult(ITestResult result) {
        test = ExtentTestManager.updateTest(test, driver, result);
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        driver.quit();

        ExtentTestManager.extent.flush();
    }
}