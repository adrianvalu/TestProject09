package Pages.DemoApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{

    private String alertUrlSelector = "#svelte > div.container-fluid > div.main.row > div.sidebar > a:nth-child(1)"; //CSS
    private String hoverUrlSelector = "#svelte > div.container-fluid > div.main.row > div.sidebar > a:nth-child(3)"; // CSS
    private String interceptorUrlSelector = "#svelte > div.container-fluid > div.main.row > div.sidebar > a:nth-child(4)"; //CSS
    private String modalUrlSelector = "#svelte > div.container-fluid > div.main.row > div.sidebar > a:nth-child(5)";// CSS
    private String welcomeTextSelector = "#svelte > div.container-fluid > div.main.row > div.content > h1"; //CSS
    private String loginUrlSelector = "#svelte > div.container-fluid > div.header.sticky-top.row > div:nth-child(2) > div > a > h2 > i";
    private String cookieUrlSelector = "#svelte > div.container-fluid > div.main.row > div.sidebar > a:nth-child(2)";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void goToAlerts()
    {
        driver.findElement(By.cssSelector(alertUrlSelector)).click();
    }

    public void goToHover(){
        driver.findElement(By.cssSelector(hoverUrlSelector)).click();
    }

    public void gotToInterceptor(){
        driver.findElement(By.cssSelector(interceptorUrlSelector)).click();
    }

    public void goToModal(){
        driver.findElement(By.cssSelector(modalUrlSelector)).click();
    }

    public String getWelcomeText() {
        return driver.findElement(By.cssSelector(welcomeTextSelector)).getText();
    }

    public void goToLogin(){

        driver.findElement(By.cssSelector(loginUrlSelector)).click();
    }


    public void goToCookie() {
        driver.findElement(By.cssSelector(cookieUrlSelector)).click();
    }
}