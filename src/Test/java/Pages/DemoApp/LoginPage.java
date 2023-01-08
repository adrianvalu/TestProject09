
package Pages.DemoApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

// This is with Page Factory design pattern
public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(how = How.XPATH, using = "//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/h1/small")
    private WebElement pageText;

    @FindBy(how = How.CSS, using = "#root > div > div.content > div > div:nth-child(1) > div > div > h1 > small")
    private WebElement pageTextCss;

    @FindBy(how = How.CLASS_NAME, using = "text-muted")
    private WebElement pageTextClass;

    @FindAll(@FindBy(how = How.CLASS_NAME, using = "text-muted"))
    private List<WebElement> elemts;

    @FindAll(@FindBy(how = How.TAG_NAME, using = "small"))
    private List<WebElement> elementsTag;

    @FindBy(how = How.CSS, using = "#login-form > div:nth-child(1) > label")
    private WebElement usernameLabel;

    @FindBy(how = How.CSS, using = "#login-form > div.form-group.row.row-cols-lg-true > label")
    private WebElement passwordLabel;

    //    @FindBy(how = How.ID, using = "input-login-username")
    @FindBy(how = How.ID, using = "user")
    private WebElement usernameInput;

    //    @FindBy(how = How.ID, using = "input-login-password")
    @FindBy(how = How.ID, using = "pass")
    private WebElement passwordInput;

    //    @FindBy(how = How.CSS, using = "#login-form > div:nth-child(3) > div.text-left.col-lg > button")
    @FindBy(how = How.CSS, using = "#svelte > div.container-fluid > div.main.row > div.content > div > div > div > form > button")
    private WebElement submitButton;

    //    @FindBy(how = How.CSS, using = "#login-form > div:nth-child(1) > div > div > div.text-left.invalid-feedback")
    @FindBy(xpath = "//*[@id='svelte']/div[1]/div[2]/div[2]/div/div/div/form/div[1]/small")
    private WebElement usernameError;

    //    @FindBy(how = How.CSS, using = "#login-form > div.form-group.row.row-cols-lg-true > div > div > div.text-left.invalid-feedback")
    @FindBy(xpath = "//*[@id='svelte']/div[1]/div[2]/div[2]/div/div/div/form/div[2]/small")
    private WebElement passwordError;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    public void verifyPage() {
        Assert.assertEquals(pageText.getText(), "Authentication");
        Assert.assertEquals(pageTextCss.getText(), "Authentication");
        Assert.assertEquals(pageTextClass.getText(), "Authentication");
        Assert.assertEquals(usernameLabel.getText(), "Username");
        Assert.assertEquals(passwordLabel.getText(), "Password");
    }

    public void login(String username, String password, String userError, String passError) {
        login(username, password);
        Assert.assertEquals(usernameError.getText(), userError);
        Assert.assertEquals(passwordError.getText(), passError);
    }

    public void login(String username, String password) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        submitButton.submit();
    }

    public String getUsernameError() {
        return usernameError.getText();
    }

    public String getPasswordError() {
        return passwordError.getText();
    }

    public boolean checkErr(String expectedErr, String errorType) {
        if (errorType.equalsIgnoreCase("userErr")) {
            if (expectedErr.length() > 0) {
                System.out.println("Actual user error:" + usernameError.getText());
                return expectedErr.equals(usernameError.getText());
            } else return true;
        } else if (errorType.equalsIgnoreCase("passErr")) {
            if (expectedErr.length() > 0) {
                System.out.println("Actual pass error:" + passwordError.getText());
                return expectedErr.equalsIgnoreCase(passwordError.getText());
            } else return true;
        }
        return false;
    }

}