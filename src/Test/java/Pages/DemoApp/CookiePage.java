package Pages.DemoApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CookiePage extends BasePage {

    private String cookiePageTextSelector = "#svelte > div.container-fluid > div.main.row > div.content > h1";
    private String setTheCookieButtonSelector = "set-cookie";
    private String cookieValueSelector = "cookie-value";


    public CookiePage(WebDriver driver) {
        super(driver);
    }

    public void setCookie() {

        WebElement removeTheCookieButton = driver.findElement(By.id(setTheCookieButtonSelector));
        removeTheCookieButton.click();

    }

    public String getCookieValue() {
        return driver.findElement(By.id(cookieValueSelector)).getText();
    }

    public String getCookieText() {
        return driver.findElement(By.cssSelector(cookiePageTextSelector)).getText();
    }
}
