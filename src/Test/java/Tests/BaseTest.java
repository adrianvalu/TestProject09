package Tests;

import ObjectModels.LoginModel;
import ObjectModels.RegistrationModel;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.RegistrationPage;
import Utils.*;
import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseTest {

    public WebDriver driver;
    String usedConfig = ConstantUtils.CONFIG_FILE;
    String baseUrl = GenericUtils.createBaseUrl(ConstantUtils.CONFIG_FILE);
    String dbHostname;
    String dbUser;
    String dbSchema;
    String dbPassword;
    String dbPort;
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


    void printDataRegistration(RegistrationModel rm) {
        System.out.println(rm);
    }

    void registerActions(RegistrationModel rm) {
        driver.get(baseUrl);
        System.out.println("Browser:" + browser);
        System.out.println("BaseUrl:" + baseUrl);

        MainPage mp = new MainPage(driver);
        Assert.assertEquals(mp.getCategoriiText(), "CATEGORII");
        mp.hoverButtonInteract();
        mp.goToRegistration();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        Assert.assertEquals(registrationPage.getRegistrationPageText(), "Creați Cont client nou");

        registrationPage.register(rm.getAccountRegister().getFirstName(), rm.getAccountRegister().getLastName(), rm.getAccountRegister().getUsername(), rm.getAccountRegister().getPassword(), rm.getAccountRegister().getConfirmPassword());

        String expectedFirstNameErr = rm.getFirstNameError();
        String expectedLastNameErr = rm.getLastNameError();
        String expectedUsernameErr = rm.getUserError();
        String expectedPassErr = rm.getPasswordError();
        String expectedConfirmPassErr = rm.getConfirmPasswordError();

        System.out.println("Verify expected errors present:\nExpected firstnameError:" + expectedFirstNameErr);
        Assert.assertTrue(registrationPage.checkErr(expectedFirstNameErr, "firstNameErr"));

        System.out.println("Expected lastnameError:" + expectedLastNameErr);
        Assert.assertTrue(registrationPage.checkErr(expectedLastNameErr, "lastNameErr"));

        System.out.println("Expected usernameError:" + expectedUsernameErr);
        Assert.assertTrue(registrationPage.checkErr(expectedUsernameErr, "userErr"));

        System.out.println("Expected passwordError:" + expectedPassErr);
        Assert.assertTrue(registrationPage.checkErr(expectedPassErr, "passErr"));

        System.out.println("Expected confirmedPasswordError:" + expectedConfirmPassErr);
        Assert.assertTrue(registrationPage.checkErr(expectedConfirmPassErr, "confirmPassErr"));
    }

    void printDataLogin(LoginModel lm) {
        System.out.println(lm);
    }

    void loginActions(LoginModel lm) {

        driver.get(baseUrl);
        System.out.println("Browser:" + browser);
        System.out.println("BaseUrl:" + baseUrl);

        MainPage mp = new MainPage(driver);
        Assert.assertEquals(mp.getCategoriiText(), "CATEGORII");
        mp.hoverButtonInteract();
        mp.goToLogin();
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals(loginPage.getLoginPageText(), "Conectare client");
//         login
        loginPage.loginDataInput(lm.getAccount().getUsername(), lm.getAccount().getPassword());

        String expectedUsernameErr = lm.getUserError();
        String expectedPassErr = lm.getPasswordError();

        System.out.println("Verify expected errors present:\nExpected usernameError:" + expectedUsernameErr);
        Assert.assertTrue(loginPage.checkErr(expectedUsernameErr, "userErr"));

        System.out.println("Expected Password Err:" + expectedPassErr);
        Assert.assertTrue(loginPage.checkErr(expectedPassErr, "passErr"));
    }

    protected String getEscapedElement(ResultSet resultSet, String element) throws SQLException {
        return Tools.replaceElements(resultSet.getString(element), "''", "");
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        driver.quit();
        ExtentTestManager.extent.flush();
    }
}