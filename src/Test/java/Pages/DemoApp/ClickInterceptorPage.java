package Pages.DemoApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ClickInterceptorPage extends BasePage{
    private String pageLabelSelector = "#svelte > div.container-fluid > div.main.row > div.content > h1"; //CSS
    private String checkboxSelector = "#svelte > div.container-fluid > div.main.row > div.content > div > label > span"; // CSS





    public ClickInterceptorPage(WebDriver driver) {
        super(driver);
    }

    public String getPageLabel() {
        return driver.findElement(By.cssSelector(pageLabelSelector)).getText();
    }

    public void clickCheckbox() {
        WebElement checkbox = driver.findElement(By.cssSelector(checkboxSelector));
        Actions actions = new Actions(driver);
        actions.click(checkbox).build().perform();
    }


}