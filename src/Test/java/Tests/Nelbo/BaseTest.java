package Tests.Nelbo;

import Pages.Nelbo.MainPage;
import Utils.BrowserUtils;
import Utils.ConstantUtils;
import Utils.GenericUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public WebDriver driver;
    String browser = GenericUtils.getBrowserConfig(ConstantUtils.CONFIG_FILE);
    String baseUrl = GenericUtils.createBaseUrl(ConstantUtils.CONFIG_FILE);


    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        driver = BrowserUtils.getBrowser(browser, ConstantUtils.CONFIG_FILE);
        driver.manage().window().maximize();
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
    //driver.quit();
    }
}