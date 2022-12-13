package Pages.MyPCTM;

import Pages.DemoApp.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AccountEditPage extends BasePage {

    private String personalDataSelector = "#content > form > div.page-content > h4"; //CSS
    private String surnameLabelSelector = "#content > form > div.page-content > table > tbody > tr:nth-child(1) > td:nth-child(1) > span"; // CSS
    private String surnameInputSelector = "#content > form > div.page-content > table > tbody > tr:nth-child(1) > td:nth-child(2) > input[type=text]"; //cSS
    private String nameLabelSelector = "#content > form > div.page-content > table > tbody > tr:nth-child(2) > td:nth-child(1) > span"; // CSS
    private String nameInputSelector = "#content > form > div.page-content > table > tbody > tr:nth-child(2) > td:nth-child(2) > input[type=text]"; // CSS
    private String emailLabelSelector = "#content > form > div.page-content > table > tbody > tr:nth-child(3) > td:nth-child(1) > span"; // CSS
    private String emailInputSelector = "#content > form > div.page-content > table > tbody > tr:nth-child(3) > td:nth-child(2) > input[type=text]"; // CSS
    private String phoneLabelSelector = "#content > form > div.page-content > table > tbody > tr:nth-child(4) > td:nth-child(1) > span"; //CSS
    private String phoneInputSelector = "#content > form > div.page-content > table > tbody > tr:nth-child(4) > td:nth-child(2) > input[type=text]"; // CSS
    private String submitButtonSelector = "#content > form > div.buttons > div.right > input"; // CSS

    public AccountEditPage(WebDriver driver) {
        super(driver);
    }

    public void verifyPage() {
        Assert.assertEquals(driver.findElement(By.cssSelector(personalDataSelector)).getText(), "Date personale");
        Assert.assertEquals(driver.findElement(By.cssSelector(surnameLabelSelector)).getText(), "Prenume:");
        Assert.assertEquals(driver.findElement(By.cssSelector(nameLabelSelector)).getText(), "Nume de familie:");
        Assert.assertEquals(driver.findElement(By.cssSelector(emailLabelSelector)).getText(), "E-Mail:");
        Assert.assertEquals(driver.findElement(By.cssSelector(phoneLabelSelector)).getText(), "Telefon:");
    }

    public void editAccountDetails(String surname, String name, String email, String phone) {
        WebElement surnameElement = driver.findElement(By.cssSelector(surnameInputSelector));
        surnameElement.clear();
        surnameElement.sendKeys(surname);
        WebElement nameElement = driver.findElement(By.cssSelector(nameInputSelector));
        nameElement.clear();
        nameElement.sendKeys(name);
        WebElement emailElement = driver.findElement(By.cssSelector(emailInputSelector));
        emailElement.clear();
        emailElement.sendKeys(email);
        WebElement phoneElement = driver.findElement(By.cssSelector(phoneLabelSelector));
        phoneElement.clear();
        phoneElement.sendKeys(phone);
        WebElement submitButton = driver.findElement(By.cssSelector(submitButtonSelector));
        submitButton.submit();
    }

}