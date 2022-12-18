package Tests.DemoApp;

import Pages.DemoApp.AlertPage;
import Pages.DemoApp.ClickInterceptorPage;
import Pages.DemoApp.HoverPage;
import Pages.DemoApp.MainPage;
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

}