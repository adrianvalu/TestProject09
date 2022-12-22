package Pages.DemoApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

// This is classic Page Object Model
public class LoginPOMPage extends BasePage {

    private String pageTextSelector = "//*[@id=\"svelte\"]/div[1]/div[2]/div[2]/h1";
    private String pageTextCssSelector = "#root > div > div.content > div > div:nth-child(1) > div > div > h1 > small";
    private String pageTextClassSelector = "text-muted";
    private String elemtsSelector = "text-muted";
    private String elementsTagSelector = "small";
    private String usernameLabelSelector = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(1) > label";
    private String passwordLabelSelector = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(2) > label";
    private String registerSelector = "#svelte > div.container-fluid > div.main.row > div.content > p:nth-child(3) > div > a";
    private String loginTextSelector = "#svelte > div.container-fluid > div.main.row > div.content > h1";
    private String usernameInputSelector = "user";
    private String passwordInputSelector = "pass";
    private String submitButtonSelector = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > button";
    private String usernameErrorSelector = "form-error";
    private String passwordErrorSelector = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(2) > small";

    public LoginPOMPage(WebDriver driver) {
        super(driver);
    }

    public void verifyPage() {
        Assert.assertEquals(driver.findElement(By.xpath(pageTextSelector)).getText(),"Sign in");

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
        return driver.findElement(By.className(usernameErrorSelector)).getText();
    }

    public String getPasswordError() {
        return driver.findElement(By.cssSelector(passwordErrorSelector)).getText();
    }

    public String getLoginText() {
        return driver.findElement(By.cssSelector(loginTextSelector)).getText();
    }

    public void goToRegister(){

        driver.findElement(By.cssSelector(registerSelector)).click();
    }


}