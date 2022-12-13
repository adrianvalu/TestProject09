
package Tests.DemoApp;

import Pages.DemoApp.LoginPOMPage;
import Pages.DemoApp.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class LoginTests extends BaseTest{


    // Test with Page Factory with Asserts outside for actions
    @Test
    public void loginPositiveTest() {
        driver.get(baseUrl + "#/login");
        LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
        lp.verifyPage();
        lp.login("abc", "password");
        Assert.assertEquals(lp.getUsernameError(),"");
        Assert.assertEquals(lp.getPasswordError(),"");
    }

    // Test with Page Factory with Asserts inside the Page Object class
    @Test
    public void loginPositive2Test() {
        driver.get(baseUrl + "#/login");
        LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
        lp.verifyPage();
        lp.login("abc", "password", "", "");
    }

    //
    @Test
    public void loginPositivePomTest() {
        driver.get(baseUrl + "#/login");
        LoginPOMPage lp = new LoginPOMPage(driver);
        lp.verifyPage();
        lp.login("abc", "password");
    }

    @DataProvider(name = "loginData")
    public Iterator<Object[]> loginDataProvider() {
        Collection<Object[]> dp = new ArrayList<>();
        dp.add(new String[] { "alex", "abc123", "", "" } );
        dp.add(new String[] { "", "", "Username is required!", "Password is required!" } );
        dp.add(new String[] { "alex", "", "", "Password is required!"  });
        dp.add(new String[] { "", "abc123", "Username is required!", "" });
        return dp.iterator();
    }

    @Test(dataProvider = "loginData")
    public void loginDpTest(String username, String password, String userErr, String passErr) {
        driver.get(baseUrl + "#/login");
        LoginPOMPage lp = new LoginPOMPage(driver);
        lp.verifyPage();
        lp.login(username, password);
        Assert.assertEquals(lp.getUsernameError(), userErr);
        Assert.assertEquals(lp.getPasswordError(), passErr);

    }



}