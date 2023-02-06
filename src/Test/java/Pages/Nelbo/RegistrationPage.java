package Pages.Nelbo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RegistrationPage extends BasePage {

    //for project

    private String registrationPageTextSelector = "body > main > div > div.page-title-wrapper > div > h1 > span";
    private String firstNameInputSelector = "firstname";
    private String lastNameInputSelector = "lastname";
    private String emailInputSelector = "email_address";
    private String passwordInputSelector = "password";
    private String confirmPasswordInputSelector = "password-confirmation";
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

    public void register(String firstName, String lastName, String email, String password, String confirmPassword) {
        WebElement firstNameInput = driver.findElement(By.id(firstNameInputSelector));
        WebElement lastNameInput = driver.findElement(By.id(lastNameInputSelector));
        WebElement emailInput = driver.findElement(By.id(emailInputSelector));
        WebElement passwordInput = driver.findElement(By.id(passwordInputSelector));
        WebElement confirmPasswordInput = driver.findElement(By.id(confirmPasswordInputSelector));
        WebElement submitButton = driver.findElement(By.cssSelector(registerButtonSelector));

        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        emailInput.clear();
        emailInput.sendKeys(email);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(confirmPassword);

        submitButton.submit();

    }

    public boolean checkErr(String expectedErr, String errorType) {
        if (errorType.equalsIgnoreCase("firstNameErr")) {
            if (expectedErr.length() > 0) {
                return expectedErr.equals(getFirstNameErrorText());
            } else return true;
        } else if (errorType.equalsIgnoreCase("lastNameErr")) {
            if (expectedErr.length() > 0) {
                return expectedErr.equalsIgnoreCase(getLastNameErrorText());
            } else return true;
        } else if (errorType.equalsIgnoreCase("userErr")) {
            if (expectedErr.length() > 0) {
                return expectedErr.equalsIgnoreCase(getEmailErrorText());
            } else return true;
        } else if (errorType.equalsIgnoreCase("passErr")) {
            if (expectedErr.length() > 0) {
                return expectedErr.equalsIgnoreCase(getPasswordErrorText());
            } else return true;
        } else if (errorType.equalsIgnoreCase("confirmPassErr")) {
            if (expectedErr.length() > 0) {
                return expectedErr.equalsIgnoreCase(getConfirmPasswordErrorText());
            } else return true;
        }
        return false;
    }

}
