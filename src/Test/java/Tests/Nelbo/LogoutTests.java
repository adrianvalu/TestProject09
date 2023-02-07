package Tests.Nelbo;

import Pages.Nelbo.LoginPage;
import Pages.Nelbo.LogoutPage;
import Pages.Nelbo.MainPage;
import Utils.ExtentTestManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


public class LogoutTests extends BaseTest {

    @Test(groups = "Regression")
    public void logoutTest (Method method) {
        test = ExtentTestManager.startTest(method.getName(), "");
        driver.get(baseUrl);
        System.out.println("Browser:" + browser);
        System.out.println("BaseUrl:" + baseUrl);
        LogoutPage lgp = new LogoutPage(driver);
        lgp.logare();
        lgp.hoverButtonInteract();
        lgp.deconectare();
        Assert.assertEquals(lgp.getLogoutConfirmationText(), "V-ați deconectat și veți merge la pagina principală in 5 secunde.");


    }
}
