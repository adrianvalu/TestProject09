package Pages.MyPCTM;

import Pages.DemoApp.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends BasePage {

    private String existingClientSelector = "#content > div > div > div:nth-child(2) > div > h2"; // CSS
    private String emailLabelSelector = "#content > div > div > div:nth-child(2) > div > form > div > b:nth-child(2)"; // CSS
    private String passwordLabelSelector = "#content > div > div > div:nth-child(2) > div > form > div > b:nth-child(6)"; //CSS
    private String emailInputSelector = "#content > div > div > div:nth-child(2) > div > form > div > input[type=text]:nth-child(4)"; // CSS
    private String passwordInputSelector = "#content > div > div > div:nth-child(2) > div > form > div > input[type=password]:nth-child(8)"; // CSS
    private String submitButtonSelector = "#content > div > div > div:nth-child(2) > div > form > div > input.button"; // CSS

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void verifyPage() {
        Assert.assertEquals(driver.findElement(By.cssSelector(existingClientSelector)).getText(), "Client existent");
        Assert.assertEquals(driver.findElement(By.cssSelector(emailLabelSelector)).getText(), "Adresa de e-mail:");
        Assert.assertEquals(driver.findElement(By.cssSelector(passwordLabelSelector)).getText(), "Parola:");
    }

    public void login(String username, String password) {
        WebElement emailInput = driver.findElement(By.cssSelector(emailInputSelector));
        WebElement passwordInput = driver.findElement(By.cssSelector(passwordInputSelector));
        WebElement submitButton = driver.findElement(By.cssSelector(submitButtonSelector));

        emailInput.clear();
        emailInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        submitButton.submit();
    }
}