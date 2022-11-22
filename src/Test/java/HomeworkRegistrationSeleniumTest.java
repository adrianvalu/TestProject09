import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class HomeworkRegistrationSeleniumTest {

    WebDriver driver;
    String browser = "Chrome";

    @BeforeTest
    public void beforeTest() {
        if (browser.toLowerCase().equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        if (browser.toLowerCase().equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        if (browser.toLowerCase().equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
    }

    @DataProvider(name = "registrationData")
    public Iterator<Object[]> registrationDataProvider() {
        Collection<Object[]> dp = new ArrayList<>();
        dp.add(new String[]{"alex", "abcd1234", "test@test.com", "", "", ""});
        dp.add(new String[]{"", "", "", "Username is required!", "Password is required!", "Email is required!"});
        dp.add(new String[]{"alex", "", "", "", "Password is required!", "Email is required!"});
        dp.add(new String[]{"alex", "abcd1234", "", "", "", "Email is required!"});
        dp.add(new String[]{"alex", "", "test@test.com", "", "Password is required!", ""});
        dp.add(new String[]{"", "abcd1234", "", "Username is required!", "", "Email is required!"});
        dp.add(new String[]{"", "abcd1234", "test@test.com", "Username is required!", "", ""});
        dp.add(new String[] { "", "", "test@test.com", "Username is required!", "Password is required!", "" } );

        return dp.iterator();
    }

        @Test(dataProvider = "registrationData")
        public void registrationTest (String username, String password, String email, String userError, String
        passError, String emailError){

            driver.get("http://86.121.249.151:4999/#/registration");

            WebElement pageText = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/h1/small"));

            List<WebElement> elements = driver.findElements(By.className("text-muted"));
            System.out.println(elements.size());

            Assert.assertEquals(pageText.getText(), "Registration");
            System.out.println(elements.get(1).getText());

            WebElement usernameLabel = driver.findElement(By.cssSelector("#registration-form > div:nth-child(2) > label"));
            WebElement passwordLabel = driver.findElement(By.cssSelector("#registration-form > div:nth-child(3) > label"));
            WebElement confirmPasswordLabel = driver.findElement(By.cssSelector("#registration-form > div:nth-child(4) > label"));
            WebElement titleLabel = driver.findElement(By.cssSelector("#registration-form > div:nth-child(6) > label"));
            WebElement firstNameLabel = driver.findElement(By.cssSelector("#registration-form > div:nth-child(7) > label"));
            WebElement lastNameLabel = driver.findElement(By.cssSelector("#registration-form > div:nth-child(8) > label"));
            WebElement emailLabel = driver.findElement(By.cssSelector("#registration-form > div:nth-child(9) > label"));
            WebElement dateOfBirthLabel = driver.findElement(By.cssSelector("#registration-form > div:nth-child(10) > label"));
            WebElement nationalityLabel = driver.findElement(By.cssSelector("#registration-form > div:nth-child(11) > label"));
            WebElement termsAndConditionLabel = driver.findElement(By.cssSelector("#registration-form > div:nth-child(12) > div.text-left.col-lg > div > label"));

            Assert.assertEquals(usernameLabel.getText(), "Username");
            Assert.assertEquals(passwordLabel.getText(), "Password");
            Assert.assertEquals(confirmPasswordLabel.getText(), "Confirm password");
            Assert.assertEquals(titleLabel.getText(), "Title");
            Assert.assertEquals(firstNameLabel.getText(), "First name");
            Assert.assertEquals(lastNameLabel.getText(), "Last name");
            Assert.assertEquals(emailLabel.getText(), "Email");
            Assert.assertEquals(dateOfBirthLabel.getText(), "Date of birth");
            Assert.assertEquals(nationalityLabel.getText(), "Nationality");
            Assert.assertEquals(termsAndConditionLabel.getText(), "I accept the terms and conditions");

            WebElement usernameInput = driver.findElement(By.id("input-username"));
            WebElement passwordInput = driver.findElement(By.id("input-password"));
            WebElement emailInput = driver.findElement(By.id("input-email"));
            WebElement termsAndConditionCheck = driver.findElement(By.id("terms"));

            usernameInput.clear();
            usernameInput.sendKeys(username);
            passwordInput.clear();
            passwordInput.sendKeys(password);
            emailInput.clear();
            emailInput.sendKeys(email);

            termsAndConditionCheck.click();

            WebElement submitButton = driver.findElement(By.cssSelector("#registration-form > div:nth-child(13) > div.text-left.col-lg > button"));
            submitButton.submit();

            WebElement usernameError = driver.findElement(By.cssSelector("#registration-form > div:nth-child(2) > div > div > div.text-left.invalid-feedback"));
            WebElement passwordError = driver.findElement(By.cssSelector("#registration-form > div:nth-child(3) > div > div > div.text-left.invalid-feedback"));
            WebElement emailUserError = driver.findElement(By.cssSelector("#registration-form > div:nth-child(9) > div > div > div.text-left.invalid-feedback"));

            Assert.assertEquals(usernameError.getText(), userError);
            Assert.assertEquals(passwordError.getText(), passError);
            Assert.assertEquals(emailUserError.getText(), emailError);


        }

        @AfterTest
    public void afterTest(){
        driver.quit();
    }


    }

