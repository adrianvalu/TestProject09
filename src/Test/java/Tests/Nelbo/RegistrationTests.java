package Tests.Nelbo;



import Pages.Nelbo.MainPage;
import Pages.Nelbo.RegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest {

    @Test
    public void CheckBoxTest03() {
        driver.get(baseUrl3);
        MainPage mp = new MainPage(driver);
        Assert.assertEquals(mp.getControlereText(), "Controlere");
        mp.hoverButtonInteract();
        String registrationSelector = "body > main > div > header > div.bottom-header-content > div > div > div.col-lg-9.col-md-9.col-xs-12 > div > div.table-icon-menu > div.dropdown.dropdown-toplinks > div > ul > li:nth-child(4) > a";
        WebElement userRegistration = driver.findElement(By.cssSelector(registrationSelector));
        userRegistration.click();

        RegistrationPage cip = new RegistrationPage(driver);
        Assert.assertEquals(cip.getRegistrationPageText(), "Creați Cont client nou");


        cip.clickCheckbox3();
        cip.acceptCookies();
        cip.register();

        Assert.assertEquals(cip.getFirstNameErrorText(), "Acesta este un câmp obligatoriu.");
        Assert.assertEquals(cip.getSurNameErrorText(), "Acesta este un câmp obligatoriu.");
        Assert.assertEquals(cip.getEmailErrorText(), "Acesta este un câmp obligatoriu.");
        Assert.assertEquals(cip.getPasswordErrorText(), "Acesta este un câmp obligatoriu.");
        Assert.assertEquals(cip.getConfirmPasswordErrorText(), "Acesta este un câmp obligatoriu.");


    }
}
