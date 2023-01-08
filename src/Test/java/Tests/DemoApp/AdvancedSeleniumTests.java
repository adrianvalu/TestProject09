package Tests.DemoApp;

import Pages.DemoApp.AlertPage;
import Pages.DemoApp.ClickInterceptorPage;
import Pages.DemoApp.HoverPage;
import Pages.DemoApp.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdvancedSeleniumTests extends  BaseTest{

    @Test
    public void AlertTest01() {
        driver.get(baseUrl);
        MainPage mp = new MainPage(driver);
        Assert.assertEquals(mp.getWelcomeText(), "Welcome to web-stubs, guest!");
        mp.goToAlerts();
        AlertPage ap = new AlertPage(driver);
        Assert.assertEquals(ap.getPageLabelText(), "Alerts");
        ap.clickAlertButton();
        ap.acceptAlert();
        ap.clickConfirmButton();
        ap.dismissAlert();
        ap.clickPromptButton();
        ap.inputAcceptAlert("Alex");
    }

    @Test
    public void HoverTest01(){
        driver.get(baseUrl);
        MainPage mp = new MainPage(driver);
        Assert.assertEquals(mp.getWelcomeText(), "Welcome to web-stubs, guest!");
        mp.goToHover();
        HoverPage hp = new HoverPage(driver);
        Assert.assertEquals(hp.getPageLabel(), "Hover");
        hp.hoverButtonInteract();
    }

    @Test
    public void CheckBoxTest01() {
        driver.get(baseUrl);
        MainPage mp = new MainPage(driver);
        Assert.assertEquals(mp.getWelcomeText(), "Welcome to web-stubs, guest!");
        mp.gotToInterceptor();
        ClickInterceptorPage cip = new ClickInterceptorPage(driver);

        Assert.assertEquals(cip.getPageLabel(), "Click intercepted");
        cip.clickCheckbox();
    }

    @Test
    public void CheckBoxTest02() {
        driver.get(baseUrl);
        MainPage mp = new MainPage(driver);
        Assert.assertEquals(mp.getWelcomeText(), "Welcome to web-stubs, guest!");
        mp.gotToInterceptor();
        ClickInterceptorPage cip = new ClickInterceptorPage(driver);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement expectedText = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#svelte > div.container-fluid > div.main.row > div.content > h1")));

        Assert.assertEquals(expectedText.getText(), "Click intercepted");
        cip.clickCheckbox();
    }

    @Test
    public void CheckBoxTest03() {
        driver.get(baseUrl3);

        ClickInterceptorPage cip = new ClickInterceptorPage(driver);


        cip.clickCheckbox3();

        String acceptCookieSelector = "#btn-cookie-allow > span";
        WebElement acceptCookie = driver.findElement(By.cssSelector(acceptCookieSelector));
        acceptCookie.click();
    }

}