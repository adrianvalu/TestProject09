package Tests.Nelbo;

import Pages.Nelbo.LoginPage;
import Pages.Nelbo.MainPage;
import Pages.Nelbo.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utils.ExtentTestManager;
import java.lang.reflect.Method;

public class SearchTests extends BaseTest {


    @Test(description = "verify that you can search an existing product", groups = {"smoke", "regression"})
    public void searchProductTest(Method method) {
        test = ExtentTestManager.startTest(method.getName(), "verify that you can search an existing product");
        driver.get(baseUrl);
        System.out.println("Browser:" + browser);
        System.out.println("BaseUrl:" + baseUrl);
        MainPage mp = new MainPage(driver);
        Assert.assertEquals(mp.getCategoriiText(), "CATEGORII");
        mp.acceptCookiesPolicy();
        mp.goToSearch();
        mp.search("Memorie");
        SearchPage sp = new SearchPage(driver);
        Assert.assertEquals(sp.getMemoryText(), "Stick-uri memorie");
    }

    @Test(description = "verify that a non-existing product search return nothing")
    public void negativeSearchProductTest(Method method) {
        test = ExtentTestManager.startTest(method.getName(), "verify that a non-existing product search return nothing");
        driver.get(baseUrl);
        System.out.println("Browser:" + browser);
        System.out.println("BaseUrl:" + baseUrl);
        MainPage mp = new MainPage(driver);
        Assert.assertEquals(mp.getCategoriiText(), "CATEGORII");
        mp.goToSearch();
        mp.search("veveriyq");
        SearchPage sp = new SearchPage(driver);
        Assert.assertEquals(sp.getSearchErrorText(), "Nu s-au gasit rezultate pentru căutare.");
    }
}
