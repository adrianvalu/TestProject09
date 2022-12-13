package Tests.DemoApp;

import Utils.BrowserTypes;
import Utils.BrowserUtils;
import Utils.GenericUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public WebDriver driver;
    String browser = BrowserUtils.getBrowserExternal("autoBrowser");
    //String baseUrl = "http://86.121.249.151:4999/";
    String baseUrl = GenericUtils.createBaseUrl("src\\test\\java\\Resources\\config.properties");

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