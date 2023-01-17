package Tests.Nelbo;

import Pages.Nelbo.LoginPage;
import Pages.Nelbo.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void loginTest () {
        driver.get(baseUrl3);
        MainPage mp = new MainPage(driver);
        Assert.assertEquals(mp.getControlereText(), "Controlere");
        mp.acceptCookiesPolicy();
        mp.hoverButtonInteract();
        mp.goToLogin();
        LoginPage lp = new LoginPage(driver);
        Assert.assertEquals(lp.getLoginPageText(), "Conectare client");

    }
}