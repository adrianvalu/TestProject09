package Tests.Nelbo;

import Pages.Nelbo.LoginPage;
import Pages.Nelbo.MainPage;
import Pages.Nelbo.SearchPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends BaseTest {

    private String countItemSelector = "#narrow-by-list > div:nth-child(1) > dd > ol > li:nth-child(3) > a > span";

    @Test
    public void searchTest () {
        driver.get(baseUrl3);
        MainPage mp = new MainPage(driver);
        Assert.assertEquals(mp.getCategoriiText(), "CATEGORII");
        mp.acceptCookiesPolicy();
        mp.goToSearch();
        mp.search("Memorie RAM");
        SearchPage sp = new SearchPage(driver);
        Assert.assertEquals(sp.getMemoryText(), "Memorii RAM\n" + driver.findElement(By.cssSelector(countItemSelector)).getText());
    }

    @Test
    public void negativeSearchTest () {
        driver.get(baseUrl3);
        MainPage mp = new MainPage(driver);
        Assert.assertEquals(mp.getCategoriiText(), "CATEGORII");
        mp.acceptCookiesPolicy();
        mp.goToSearch();
        mp.search("veveriyq");
        SearchPage sp = new SearchPage(driver);
        Assert.assertEquals(sp.getSearchErrorText(), "Nu s-au gasit rezultate pentru căutare.");
    }
}