package Pages.Nelbo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RegistrationPage extends BasePage {

    //for project

    private String registrationPageTextSelector = "body > main > div > div.page-title-wrapper > div > h1 > span";
    private String firstNameInputSelector = "#firstname";
    private String surNameInputSelector = "#lastname";
    private String emailInputSelector = "#email_address";
    private String passwordInputSelector = "#password";
    private String confirmPasswordInputSelector = "#password-confirmation";
    private String firstNameErrorSelector = "firstname-error";
    private String lastNameErrorSelector = "lastname-error";
    private String emailErrorSelector = "email_address-error";
    private String passwordErrorSelector = "password-error";
    private String confirmPasswordErrorSelector = "password-confirmation-error";
    private String checkboxRegistrationSelector = "accept_gdpr";
    private String registerButtonSelector = "#form-validate > div > div > div:nth-child(2) > button > span";



    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public String getRegistrationPageText() {
        return driver.findElement(By.cssSelector(registrationPageTextSelector)).getText();
    }

    public String getFirstNameErrorText() {
        return driver.findElement(By.id(firstNameErrorSelector)).getText();
    }

    public String getLastNameErrorText() {
        return driver.findElement(By.id(lastNameErrorSelector)).getText();
    }

    public String getEmailErrorText() {
        return driver.findElement(By.id(emailErrorSelector)).getText();
    }

    public String getPasswordErrorText() {
        return driver.findElement(By.id(passwordErrorSelector)).getText();
    }

    public String getConfirmPasswordErrorText() {
        return driver.findElement(By.id(confirmPasswordErrorSelector)).getText();
    }

    public void clickCheckboxRegistration() {
        WebElement checkbox = driver.findElement(By.id(checkboxRegistrationSelector));
        Actions actions = new Actions(driver);
        actions.click(checkbox).build().perform();
    }

    public void register() {
        driver.findElement(By.cssSelector(registerButtonSelector)).click();
    }
}
