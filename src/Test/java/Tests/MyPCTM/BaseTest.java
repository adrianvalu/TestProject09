package Tests.MyPCTM;

import Utils.BrowserUtils;
import Utils.ConstantUtils;
import Utils.GenericUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public WebDriver driver;

    //String browser = BrowserUtils.getBrowserExternal("autoBrowser");
    String browser = GenericUtils.getBrowserConfig(ConstantUtils.CONFIG_FILE_2);
    String baseUrl = GenericUtils.createBaseUrl(ConstantUtils.CONFIG_FILE_2);

    @BeforeTest
    public void beforeTest() {
        System.out.println(baseUrl);
        driver = BrowserUtils.getBrowser(browser, ConstantUtils.CONFIG_FILE_2);
        //driver = BrowserUtils.getBrowser(BrowserTypes.FIREFOX).getDriver();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}