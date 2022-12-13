package Tests.LegacyTests;

import Utils.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    WebDriver driver;
    String browser = "Chrome";

    @BeforeTest
    public void beforeTest() {
        if (browser.toLowerCase().equals("chrome")) {
//            System.setProperty("webdriver.chrome.driver","C:\\Users\\algatu\\IdeaProjects\\webdrivers\\chromedriver.exe");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        if (browser.toLowerCase().equals("firefox")) {
//            System.setProperty("webdriver.gecko.driver","C:\\Users\\algatu\\IdeaProjects\\webdrivers\\geckodriver.exe");
//            System.setProperty("webdriver.firefox.marionette","C:\\Users\\algatu\\IdeaProjects\\webdrivers\\geckodriver.exe");
//            System.setProperty("webdriver.firefox.port","7055");
//            FirefoxProfile profile = new FirefoxProfile();
//            profile.setPreference("webdriver.firefox.port", 7055);
//            FirefoxOptions options = new FirefoxOptions();
//            options.setLegacy(true);
//            options.setProfile(profile);
//            driver = new FirefoxDriver(options);

//            DesiredCapabilities desired = DesiredCapabilities.firefox();
//            desired.setCapability("marionette", "true");
//            driver = new FirefoxDriver(desired);
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        if (browser.toLowerCase().equals("edge")) {
//            System.setProperty("webdriver.edge.driver", "C:\\Users\\algatu\\IdeaProjects\\webdrivers\\msedgedriver.exe");
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

    }

    @Test
    public void myFirstSeleniumTest() {
        driver.navigate().to("https://magazinulcolectionarului.ro/");
        Assert.assertEquals(driver.findElement(By.cssSelector("#komenu-navigation > ul > li.komenu-cms-block > ul > li.phone-header > a > span")).getText(),"0213 247 635");

        System.out.println(SeleniumUtils.createRandomString(20));
        WebElement myAccount = driver.findElement(By.cssSelector("#html-body > div.page-wrapper > header > div.header.content > ul > li > a > span"));
        myAccount.click();

        Assert.assertEquals(driver.findElement(By.cssSelector("#maincontent > div.page-title-wrapper > h1 > span")).getText(),"Autentificare");

        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.clear();
        emailInput.sendKeys("moscraciun@polulnord.fi");

        WebElement passInput = driver.findElement(By.id("pass"));
        passInput.clear();
        passInput.sendKeys("ILOveMsClauss");

        WebElement submitButton = driver.findElement(By.id("send2"));
        submitButton.submit();

//        WebElement errorText = driver.findElement(By.cssSelector("#maincontent > div.page.messages > div:nth-child(2) > div > div > div"));
        WebElement errorText = SeleniumUtils.waitForGenericElement(driver, By.xpath("//*[@id=\"maincontent\"]/div[3]/div[2]/div/div/div"), 10);
        String errMsg = "Conectarea la cont a fost incorectă sau contul dvs. este dezactivat temporar. Vă rugăm să așteptați și să încercați din nou mai târziu.";

        Assert.assertEquals(errorText.getText(), errMsg);
    }

    @Test
    public void mySecondSeleniumTest() {
        driver.get("https://emag.ro/");
    }

    @Test
    public void myThirdSeleniumTest() {
        driver.navigate().to("https://google.ro/");
    }

    // username, password, username error, password error
    @DataProvider(name = "loginData")
    public Iterator<Object[]> loginDataProvider() {
        Collection<Object[]> dp = new ArrayList<>();
        dp.add(new String[] { "alex", "abc123", "", "" } );
        dp.add(new String[] { "", "", "Username is required!", "Password is required!" } );
        dp.add(new String[] { "alex", "", "", "Password is required!"  });
        dp.add(new String[] { "", "abc123", "Username is required!", "" });
        return dp.iterator();
    }

    @Test(dataProvider = "loginData")
    public void basicLoginTest(String username, String password, String userError, String passError) {
        driver.get("http://86.121.249.151:4999/#/login");
        // BY XPATH
        WebElement pageText = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/h1/small"));

        // BY CSS SELECTOR
        WebElement pageTextCss = driver.findElement(By.cssSelector("#root > div > div.content > div > div:nth-child(1) > div > div > h1 > small"));

        // BY CLASS NAME
        WebElement pageTextClass = driver.findElement(By.className("text-muted"));

        // Get list of elements
        List<WebElement> elemts = driver.findElements(By.className("text-muted"));

        System.out.println(elemts.size());

        // Get list of elements using tag name
        List<WebElement> elementsTag = driver.findElements(By.tagName("small"));

        System.out.println(elementsTag.size());

        Assert.assertEquals(pageText.getText(),"Authentication");
        Assert.assertEquals(pageTextCss.getText(),"Authentication");
        Assert.assertEquals(pageTextClass.getText(), "Authentication");
        Assert.assertEquals(elemts.get(0).getText(), "Authentication");
        System.out.println(elemts.get(1).getText());

        WebElement usernameLabel = driver.findElement(By.cssSelector("#login-form > div:nth-child(1) > label"));
        WebElement passwordLabel = driver.findElement(By.cssSelector("#login-form > div.form-group.row.row-cols-lg-true > label"));

        Assert.assertEquals(usernameLabel.getText(), "Username");
        Assert.assertEquals(passwordLabel.getText(), "Password");

        WebElement usernameInput = driver.findElement(By.id("input-login-username"));
        WebElement passwordInput = driver.findElement(By.id("input-login-password"));

        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);

        WebElement submitButton = driver.findElement(By.cssSelector("#login-form > div:nth-child(3) > div.text-left.col-lg > button"));
        submitButton.submit();

        WebElement usernameError = driver.findElement(By.cssSelector("#login-form > div:nth-child(1) > div > div > div.text-left.invalid-feedback"));
        WebElement passwordError = driver.findElement(By.cssSelector("#login-form > div.form-group.row.row-cols-lg-true > div > div > div.text-left.invalid-feedback"));

        //BrowserUtilities.waitForTextOnSite(driver, By.cssSelector("#login-form > div:nth-child(1) > div > div > div.text-left.invalid-feedback"), 10, userError);
//        usernameLabel.click();
        Assert.assertEquals(usernameError.getText(), userError);
        Assert.assertEquals(passwordError.getText(), passError);

    }

    @Test
    public void waitTest() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("http://86.121.249.151:8081/lazy.html");
        WebElement clickMeButton = driver.findElement(By.id("btn1"));
        clickMeButton.click();
    }

    @Test
    public void waitTestExplicit() {
        driver.navigate().to("http://86.121.249.151:8081/lazy.html");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement clickMeButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn1")));

        clickMeButton.click();
    }

    @Test
    public void waitTestExplicitNew() {
        driver.navigate().to("http://86.121.249.151:8081/lazy.html");
        WebElement clickMeButton = SeleniumUtils.waitForGenericElement(driver, By.id("btn1"), 10);
        clickMeButton.click();
        System.out.println(clickMeButton.isDisplayed());
        System.out.println(clickMeButton.isEnabled());
        System.out.println(clickMeButton.isEnabled());
        System.out.println(clickMeButton.getAttribute("id"));
        System.out.println(clickMeButton.getCssValue("color"));
        System.out.println(clickMeButton.getTagName());
    }

    // Please don't use this !!!! Just for debugging !!!
    @Test
    public void waitTestSleep() {
        driver.navigate().to("http://86.121.249.151:8081/lazy.html");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement clickMeButton = driver.findElement(By.id("btn1"));
        clickMeButton.click();

    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}