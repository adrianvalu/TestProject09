package Tests.Nelbo;



import Pages.Nelbo.MainPage;
import Pages.Nelbo.RegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest {

    @Test
    public void registerTest () {
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
        cip.register("", "", "", "", "");

        Assert.assertEquals(cip.getFirstNameErrorText(), "Acesta este un câmp obligatoriu.");
        Assert.assertEquals(cip.getLastNameErrorText(), "Acesta este un câmp obligatoriu.");
        Assert.assertEquals(cip.getEmailErrorText(), "Acesta este un câmp obligatoriu.");
        Assert.assertEquals(cip.getPasswordErrorText(), "Acesta este un câmp obligatoriu.");
        Assert.assertEquals(cip.getConfirmPasswordErrorText(), "Acesta este un câmp obligatoriu.");

    }
}
