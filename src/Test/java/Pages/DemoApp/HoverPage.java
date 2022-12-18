package Pages.DemoApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class HoverPage extends BasePage{

    private String pageLabelSelector = "#svelte > div.container-fluid > div.main.row > div.content > h1"; //CSS
    private String hoverButtonSelector = "#svelte > div.container-fluid > div.main.row > div.content > div > button"; // CSS
    private String dogSelectionSelector = "Dog"; // ID
    private String resultTextSelector = "result"; // ID

    public HoverPage(WebDriver driver) {
        super(driver);
    }

    public String getPageLabel() {
        return driver.findElement(By.cssSelector(pageLabelSelector)).getText();
    }

    public void hoverButtonInteract() {
        WebElement hoverButton = driver.findElement(By.cssSelector(hoverButtonSelector));
//        hoverButton.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverButton).build().perform();
        driver.findElement(By.id(dogSelectionSelector)).click();
        Assert.assertEquals(driver.findElement(By.id(resultTextSelector)).getText(), "You last clicked the Dog");
    }

}