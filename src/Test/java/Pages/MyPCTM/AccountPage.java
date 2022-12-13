package Pages.MyPCTM;

import Pages.DemoApp.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountPage extends BasePage {

    private String myAccountLabelSelector = "#content > h1 > strong"; // CSS
    private String changeAccountLinkSelector = "#content > div:nth-child(3) > ul > li:nth-child(1) > a"; // CSS

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void verifyPage() {
        Assert.assertEquals(driver.findElement(By.cssSelector(myAccountLabelSelector)).getText(), "CONTUL MEU");
    }

    public void changeAccountDetails() {
        driver.findElement(By.cssSelector(changeAccountLinkSelector)).click();
    }


}