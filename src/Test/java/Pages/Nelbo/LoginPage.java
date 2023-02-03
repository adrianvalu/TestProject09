package Pages.Nelbo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private String loginPageTextSelector = "body > main > div > div.page-title-wrapper > div > h1 > span";
    private String emailLoginInputSelector = "email";
    private String passwordLoginInputSelector = "pass";
    private String emailLoginErrorSelector = "email-error";
    private String passwordLoginErrorSelector = "pass-error";
    private String submitButtonSelector = "#send2 > span";
    private String acceptGdprSelector = "accept_gdpr";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getLoginPageText() {
        return driver.findElement(By.cssSelector(loginPageTextSelector)).getText();
    }
    public String getEmailLoginErrorText() {
        return driver.findElement(By.id(emailLoginErrorSelector)).getText();
    }

    public String getPasswordLoginErrorText() {
        return driver.findElement(By.id(passwordLoginErrorSelector)).getText();
    }
    public void loginDataInput(String username, String password) {
        WebElement usernameInput = driver.findElement(By.id(emailLoginInputSelector));
        WebElement passwordInput = driver.findElement(By.id(passwordLoginInputSelector));
        WebElement submitButton = driver.findElement(By.cssSelector(submitButtonSelector));


        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);

        submitButton.submit();

    }

    public void loginAccount(String username, String password) {
        WebElement acceptGdprBox = driver.findElement(By.id(acceptGdprSelector));
        acceptGdprBox.click();
        loginDataInput(username, password);



    }

    public boolean checkErr(String expectedErr, String errorType) {
        if (errorType.equalsIgnoreCase("userErr")) {
            if (expectedErr.length() > 0) {
                return expectedErr.equals(getEmailLoginErrorText());
            } else return true;
        } else if (errorType.equalsIgnoreCase("passErr")) {
            if (expectedErr.length() > 0) {
                return expectedErr.equalsIgnoreCase(getPasswordLoginErrorText());
            } else return true;
        }
        return false;
    }
}
