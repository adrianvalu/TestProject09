package Tests.Nelbo;

import Pages.Nelbo.LoginPage;
import Pages.Nelbo.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTests extends BaseTest {

    @Test(groups = "Smoke")
    public void loginTest () {
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

    @Test
    public void abonareNewsletterTest () {
        driver.get(baseUrl);
        System.out.println("Browser:" + browser);
        System.out.println("BaseUrl:" + baseUrl);
        MainPage mp = new MainPage(driver);
        Assert.assertEquals(mp.getCategoriiText(), "CATEGORII");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mp.abonareNewsletter();
        Assert.assertEquals(mp.getAbonareError(), "");
    }


}
