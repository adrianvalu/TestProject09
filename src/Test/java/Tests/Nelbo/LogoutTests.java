package Tests.Nelbo;

import Pages.Nelbo.LogoutPage;
import Utils.ExtentTestManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


public class LogoutTests extends BaseTest {

    @Test(groups = "regression", description = "verify that you can logout from account")
    public void logoutTest() {
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
