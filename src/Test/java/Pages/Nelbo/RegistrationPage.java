package Pages.Nelbo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RegistrationPage extends BasePage {

    //for project
    private String checkboxSelector3 = "#accept_gdpr";
    private String registrationPageTextSelector = "body > main > div > div.page-title-wrapper > div > h1 > span";
    private String registerButtonSelector = "#form-validate > div > div > div:nth-child(2) > button > span";
    private String firstNameErrorSelector = "#firstname-error";
    private String surNameErrorSelector = "#lastname-error";
    private String emailErrorSelector = "#email_address-error";
    private String passwordErrorSelector = "#password-error";
    private String confirmPasswordErrorSelector = "#password-confirmation-error";


    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public String getRegistrationPageText() {
        return driver.findElement(By.cssSelector(registrationPageTextSelector)).getText();
    }

    public String getFirstNameErrorText() {
        return driver.findElement(By.cssSelector(firstNameErrorSelector)).getText();
    }

    public String getSurNameErrorText() {
        return driver.findElement(By.cssSelector(surNameErrorSelector)).getText();
    }

    public String getEmailErrorText() {
        return driver.findElement(By.cssSelector(emailErrorSelector)).getText();
    }

    public String getPasswordErrorText() {
        return driver.findElement(By.cssSelector(passwordErrorSelector)).getText();
    }

    public String getConfirmPasswordErrorText() {
        return driver.findElement(By.cssSelector(confirmPasswordErrorSelector)).getText();
    }

    public void clickCheckbox3() {
        WebElement checkbox3 = driver.findElement(By.cssSelector(checkboxSelector3));
        Actions actions = new Actions(driver);
        actions.click(checkbox3).build().perform();
    }
    public void acceptCookies() {
        String acceptCookieSelector = "#btn-cookie-allow > span";
        WebElement acceptCookie = driver.findElement(By.cssSelector(acceptCookieSelector));
        acceptCookie.click();
    }

    public void register() {
        WebElement registerButton = driver.findElement(By.cssSelector(registerButtonSelector));
        registerButton.click();
    }
}
