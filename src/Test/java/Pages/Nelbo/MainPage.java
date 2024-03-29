package Pages.Nelbo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class MainPage extends BasePage {

    private String userMenuSelector = "body > main > div > header > div.bottom-header-content > div > div > div.col-lg-9.col-md-9.col-xs-12 > div > div.table-icon-menu > div.dropdown.dropdown-toplinks > button > i";
    private String userLoginSelector = "body > main > div > header > div.bottom-header-content > div > div > div.col-lg-9.col-md-9.col-xs-12 > div > div.table-icon-menu > div.dropdown.dropdown-toplinks > div > ul > li.authorization-link > a";
    private String userRegistrationSelector = "body > main > div > header > div.bottom-header-content > div > div > div.col-lg-9.col-md-9.col-xs-12 > div > div.table-icon-menu > div.dropdown.dropdown-toplinks > div > ul > li:nth-child(4) > a";
    private String controlereSelector = "#vertical-menu-2 > li:nth-child(7) > a > span";
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getControlereText() {
        return driver.findElement(By.cssSelector(controlereSelector)).getText();
    }

    public void hoverButtonInteract() {
        WebElement hoverButton = driver.findElement(By.cssSelector(userMenuSelector));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverButton).build().perform();
        //driver.findElement(By.id(userRegistrationSelector)).click();
        //Assert.assertEquals(driver.findElement(By.id(resultTextSelector)).getText(), "You last clicked the Dog");
    }
}
