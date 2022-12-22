package Pages.DemoApp;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class RegistrationPage extends BasePage {

    private String registerTextSelector = "#svelte > div.container-fluid > div.main.row > div.content > h1";
    private String usernameLabelSelector = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(2) > label";
    private String passwordLabelSelector = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(3) > label";
    private String confirmpPasswordLabelSelector = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(4) > label";
    private String usernameInputSelector = "username";
    private String passwordInputSelector = "password";
    private String confirmPasswordInputSelector = "password2";
    private String firstNameSelector = "input-first-name";
    private String lastNameSelector = "input-last-name";
    private String acceptTermsAndConditionsSelector = "#terms";
    private String submitButtonSelector = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(13) > button";
    private String usernameErrorSelector = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(2) > small.form-error";
    private String passwordErrorSelector = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(3) > small.form-error";
    private String confirmPasswordErrorSelector = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(4) > small.form-error";
    private String firstNameErrorSelector = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(7) > small.form-error";
    private String lastNameErrorSelector = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > div:nth-child(8) > small.form-error";


    public RegistrationPage(WebDriver driver) {
        super(driver);
    }


    public void register(String username, String password, String confirmPassword, String firstName, String lastName) {
        WebElement usernameInput = driver.findElement(By.id(usernameInputSelector));
        WebElement passwordInput = driver.findElement(By.id(passwordInputSelector));
        WebElement confirmPasswordInput = driver.findElement(By.id(confirmPasswordInputSelector));
        WebElement firstNameInput = driver.findElement(By.id(firstNameSelector));
        WebElement lastNameInput = driver.findElement(By.id(lastNameSelector));
        WebElement submitButton = driver.findElement(By.cssSelector(submitButtonSelector));

        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(confirmPassword);
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        //clickCheckbox();
        submitButton.submit();

    }

    public String getUsernameError() {
        try {
            return driver.findElement(By.cssSelector(usernameErrorSelector)).getText();
        } catch (NoSuchElementException nse) {
            return "";
        }
    }
    public String getPasswordError() {
        try {
           return driver.findElement(By.cssSelector(passwordErrorSelector)).getText();
        } catch (NoSuchElementException nse) {
            return "";
        }
    }

    public String getConfirmPasswordError() {
        try {
           return driver.findElement(By.cssSelector(confirmPasswordErrorSelector)).getText();
        } catch (NoSuchElementException nse) {
            return "";
        }
    }

    public String getFirstNameError() {
        try {
            return driver.findElement(By.cssSelector(firstNameErrorSelector)).getText();
        } catch (NoSuchElementException nse) {
            return "";
        }
    }


    public String getLastNameError() {
        try {
            return driver.findElement(By.cssSelector(lastNameErrorSelector)).getText();
        } catch (NoSuchElementException nse) {
            return "";
        }
    }



        public void clickCheckbox () {
            WebElement checkbox = driver.findElement(By.cssSelector(acceptTermsAndConditionsSelector));
            Actions actions = new Actions(driver);
            actions.click(checkbox).build().perform();
            actions.sendKeys(Keys.PAGE_DOWN).build().perform();

        }

        public String getRegisterText () {
            return driver.findElement(By.cssSelector(registerTextSelector)).getText();
        }


    }


