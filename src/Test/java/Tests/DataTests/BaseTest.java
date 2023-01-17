package Tests.DataTests;

import Utils.BrowserUtils;
import Utils.ConstantUtils;
import Utils.GenericUtils;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public WebDriver driver;
    String usedConfig = ConstantUtils.CONFIG_FILE_4;
    String dbHostname, dbUser, dbSchema, dbPassword, dbPort;
    String browser = GenericUtils.getBrowserConfig(usedConfig);
    String baseUrl = GenericUtils.createBaseUrl(usedConfig);
    Base64 base64 = new Base64();

    @BeforeTest
    public void beforeTest() {
        System.out.println(baseUrl);
        driver = BrowserUtils.getBrowser(browser, usedConfig);
        dbHostname = GenericUtils.getDBHostname(usedConfig);
        dbUser = GenericUtils.getDBUser(usedConfig);
        dbPassword = GenericUtils.getDBPassword(usedConfig);
        dbPort = GenericUtils.getDBPort(usedConfig);
        dbSchema = GenericUtils.getDBSchema(usedConfig);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}