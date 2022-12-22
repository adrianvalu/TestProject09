package Tests.DemoApp;


import Pages.DemoApp.LoginPOMPage;
import Pages.DemoApp.MainPage;
import Pages.DemoApp.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class RegistrationTests extends BaseTest{


    @DataProvider(name = "registerData")
    public Iterator<Object[]> registerDataProvider() {
        Collection<Object[]> dp = new ArrayList<>();
        dp.add(new String[] { "zebra", "zebra123", "zebra123", "Thunder", "Steve", "", "", "", "", "" } );
        dp.add(new String[] { "zebra", "", "", "Thunder", "S", "", "Please choose a password", "","", "Please choose a longer last name" } );
        dp.add(new String[] { "zeb", "abc123", "", "q", "q", "Please choose a longer username", "Please choose a longer password", "Passwords do not match", "Please choose a longer first name", "Please choose a longer last name" });
        dp.add(new String[] { "", "", "", "r", "t", "Please choose a username", "Please choose a password", "", "Please choose a longer first name", "Please choose a longer last name" });
        return dp.iterator();
    }

    @Test(dataProvider = "registerData")
    public void registerDpTest(String username, String password, String confirmPassword, String firstName, String lastName, String userErr, String passErr, String confirmPassErr, String firstNameErr, String lastNameErr) {
        driver.get(baseUrl);
        MainPage mp = new MainPage(driver);
        Assert.assertEquals(mp.getWelcomeText(), "Welcome to web-stubs, guest!");
        mp.goToLogin();
        LoginPOMPage lpp = new LoginPOMPage(driver);
        Assert.assertEquals(lpp.getLoginText(), "Sign in");
        lpp.goToRegister();
        RegistrationPage rp = new RegistrationPage(driver);
        Assert.assertEquals(rp.getRegisterText(), "Sign up");

        rp.register(username, password, confirmPassword, firstName, lastName);

        Assert.assertEquals(rp.getUsernameError(), userErr);
        Assert.assertEquals(rp.getPasswordError(), passErr);
        Assert.assertEquals(rp.getConfirmPasswordError(), confirmPassErr);
        Assert.assertEquals(rp.getFirstNameError(), firstNameErr);
        Assert.assertEquals(rp.getLastNameError(), lastNameErr);



    }




}