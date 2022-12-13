package Tests.MyPCTM;

import Utils.BrowserUtils;
import Utils.GenericUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public WebDriver driver;
    String browser = BrowserUtils.getBrowserExternal("autoBrowser");
    String baseUrl = GenericUtils.createBaseUrl("src\\test\\java\\Resources\\config2.properties");

    @BeforeTest
    public void beforeTest() {
        System.out.println(baseUrl);
        driver = BrowserUtils.getBrowser(browser);
        //driver = BrowserUtils.getBrowser(BrowserTypes.FIREFOX).getDriver();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
