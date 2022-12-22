package Tests.DemoApp;

import Pages.DemoApp.CookiePage;
import Pages.DemoApp.MainPage;
import Utils.SeleniumUtils;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;


public class CookiesTests extends BaseTest {

    @Test
    public void cookieTest() {

        driver.get(baseUrl);
        MainPage mp = new MainPage(driver);
        Assert.assertEquals(mp.getWelcomeText(), "Welcome to web-stubs, guest!");
        mp.goToCookie();
        CookiePage cp = new CookiePage(driver);
        Assert.assertEquals(cp.getCookieText(), "The gibberish talking cookie");
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println(cookies.size());
        SeleniumUtils.printCookies(driver);

        cp.setCookie();
        System.out.println(driver.manage().getCookies().size());
        SeleniumUtils.printCookies(driver);

        Assert.assertEquals(cp.getCookieValue(), driver.manage().getCookieNamed("gibberish").getValue());

        Cookie c1 = new Cookie("gibberish", "555555");
        driver.manage().addCookie(c1);
        System.out.println(driver.manage().getCookies().size());
        SeleniumUtils.printCookies(driver);

        driver.manage().deleteCookie(c1);
        System.out.println(driver.manage().getCookies().size());
        SeleniumUtils.printCookies(driver);
        System.out.println("Is cookie present ? " + SeleniumUtils.checkIfCookieExistsByName(driver, "gibberish"));

    }
}
