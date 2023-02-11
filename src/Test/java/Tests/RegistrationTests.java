package Tests;


import Pages.Nelbo.LoginPage;
import Pages.Nelbo.MainPage;
import Pages.Nelbo.RegistrationPage;
import Utils.ExtentTestManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class RegistrationTests extends BaseTest {

    @Test(description = "verify that you can create a new account")
    public void registerTest(Method method) {
        test = ExtentTestManager.startTest(method.getName(), "verify that you can create a new accoun");
        driver.get(baseUrl);
        System.out.println("BaseUrl:" + baseUrl);
        MainPage mp = new MainPage(driver);
        Assert.assertEquals(mp.getCategoriiText(), "CATEGORII");
        mp.acceptCookiesPolicy();
        mp.hoverButtonInteract();
        mp.goToRegistration();

        RegistrationPage cip = new RegistrationPage(driver);
        Assert.assertEquals(cip.getRegistrationPageText(), "Creați Cont client nou");

        cip.clickCheckboxRegistration();
        cip.register("john", "doe", "qwer@yahoo.com", "test123?", "test123?");
        LoginPage lp = new LoginPage(driver);
        Assert.assertEquals(lp.getLoginPageText(), "Conectare client");
    }
}
