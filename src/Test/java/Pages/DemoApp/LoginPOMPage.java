package Pages.DemoApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

// This is classic Page Object Model
public class LoginPOMPage extends BasePage {

    private String pageTextSelector = "//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/h1/small";
    private String pageTextCssSelector = "#root > div > div.content > div > div:nth-child(1) > div > div > h1 > small";
    private String pageTextClassSelector = "text-muted";
    private String elemtsSelector = "text-muted";
    private String elementsTagSelector = "small";
    private String usernameLabelSelector = "#login-form > div:nth-child(1) > label";
    private String passwordLabelSelector = "#login-form > div.form-group.row.row-cols-lg-true > label";
    private String usernameInputSelector = "input-login-username";
    private String passwordInputSelector = "input-login-password";
    private String submitButtonSelector = "#login-form > div:nth-child(3) > div.text-left.col-lg > button";
    private String usernameErrorSelector = "#login-form > div:nth-child(1) > div > div > div.text-left.invalid-feedback";
    private String passwordErrorSelector = "#login-form > div.form-group.row.row-cols-lg-true > div > div > div.text-left.invalid-feedback";

    public LoginPOMPage(WebDriver driver) {
        super(driver);
    }

    public void verifyPage() {
        Assert.assertEquals(driver.findElement(By.xpath(pageTextSelector)).getText(),"Authentication");

    }

    public void login(String username, String password) {
        WebElement usernameInput = driver.findElement(By.id(usernameInputSelector));
        WebElement passwordInput = driver.findElement(By.id(passwordInputSelector));
        WebElement submitButton = driver.findElement(By.cssSelector(submitButtonSelector));

        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);

        submitButton.submit();

    }

    public String getUsernameError() {
        return driver.findElement(By.cssSelector(usernameErrorSelector)).getText();
    }

    public String getPasswordError() {
        return driver.findElement(By.cssSelector(passwordErrorSelector)).getText();
    }


}