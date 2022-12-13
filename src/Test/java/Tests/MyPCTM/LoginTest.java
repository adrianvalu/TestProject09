package Tests.MyPCTM;

import Pages.MyPCTM.AccountEditPage;
import Pages.MyPCTM.AccountPage;
import Pages.MyPCTM.LoginPage;
import Utils.GenericUtils;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void loginBasicTest() {
        driver.get(baseUrl + "/index.php?route=account/login");

        LoginPage lp = new LoginPage(driver);
        lp.verifyPage();
        lp.login("test@test.com", "eVJc34NBU9xvtwT");

    }

    @Test
    public void changeDetailsTest() {
        driver.get(baseUrl + "/index.php?route=account/login");

        LoginPage lp = new LoginPage(driver);
        lp.verifyPage();
        lp.login("test@test.com", "eVJc34NBU9xvtwT");

        AccountPage ap = new AccountPage(driver);
        ap.verifyPage();
        ap.changeAccountDetails();

        AccountEditPage aep = new AccountEditPage(driver);
        //aep.verifyPage();
        aep.editAccountDetails(
                GenericUtils.createRandomString(10),
                GenericUtils.createRandomString(10),
                "test@test.com",
                "7000000000");
    }

}