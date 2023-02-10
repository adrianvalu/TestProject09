package Tests.Nelbo;

import Pages.Nelbo.LoginPage;
import Pages.Nelbo.MainPage;
import Utils.ExtentTestManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class LoginTests extends BaseTest {

    @Test(groups = "smoke", description = "verify that you can login in account")
    public void loginPositiveTest(Method method) {
        test = ExtentTestManager.startTest(method.getName(), "verify that you can login in account");
        driver.get(baseUrl);
        System.out.println("Browser:" + browser);
        System.out.println("BaseUrl:" + baseUrl);
        MainPage mp = new MainPage(driver);
        Assert.assertEquals(mp.getCategoriiText(), "CATEGORII");
        mp.acceptCookiesPolicy();
        mp.hoverButtonInteract();
        mp.goToLogin();
        LoginPage lp = new LoginPage(driver);
        Assert.assertEquals(lp.getLoginPageText(), "Conectare client");
        lp.loginAccount("elena_tiuca@yahoo.com", "test123!");
        mp.hoverButtonInteract();
        Assert.assertEquals(mp.getDeconectareText(), "Deconectare");
    }

    @Test(description = "verify that you can subscribe to newsletter")
    public void abonareNewsletterTest(Method method) {
        test = ExtentTestManager.startTest(method.getName(), "verify that you can subscribe to newsletter");
        driver.get(baseUrl);
        System.out.println("Browser:" + browser);
        System.out.println("BaseUrl:" + baseUrl);
        MainPage mp = new MainPage(driver);
        Assert.assertEquals(mp.getCategoriiText(), "CATEGORII");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mp.abonareNewsletter("test@erty.com");
        Assert.assertEquals(mp.getAbonareError(), "");
    }

}
