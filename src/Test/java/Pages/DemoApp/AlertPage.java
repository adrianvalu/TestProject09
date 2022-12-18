package Pages.DemoApp;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage extends BasePage{

    private String alertButtonSelector = "alert-trigger"; //ID
    private String confirmButtonSelector = "confirm-trigger"; // ID
    private String promptSelector = "prompt-trigger"; // ID
    private String pageLabelSelector = "#svelte > div.container-fluid > div.main.row > div.content > h1"; //CSS

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    public String getPageLabelText() {
        return driver.findElement(By.cssSelector(pageLabelSelector)).getText();
    }

    public void clickAlertButton() {
        driver.findElement(By.id(alertButtonSelector)).click();
    }

    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }

    public void dismissAlert() {
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();
    }

    public void inputAcceptAlert(String inputAlert){
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys(inputAlert);
        alert.accept();
    }


    public void clickConfirmButton() {
        driver.findElement(By.id(confirmButtonSelector)).click();
    }

    public void clickPromptButton() {
        driver.findElement(By.id(promptSelector)).click();
    }

}