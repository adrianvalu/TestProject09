package Tests.MyPCTM;

import Utils.GenericUtils;
import Utils.SeleniumUtils;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import java.util.Set;

public class CookieTests extends BaseTest{

    @Test
    public void cookieTest01() {
        driver.get(baseUrl);
        SeleniumUtils.printCookies(driver);
        SeleniumUtils.takeScreenshot(driver);
    }

    @Test
    public void cookieTest02() {
        driver.get(baseUrl);
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println(cookies.size());
        Cookie c1 = new Cookie("mycookie", "my cookie value");
        driver.manage().addCookie(c1);
        System.out.println(driver.manage().getCookies().size());
//        GenericUtils.printCookies(driver);
        driver.manage().deleteCookieNamed("mycookie");

        Cookie c2 = driver.manage().getCookieNamed("_gat");
        System.out.println(c2);

        System.out.println("Is cookie present ? " + SeleniumUtils.checkIfCookieExistsByName(driver, "_gat"));
        driver.manage().deleteCookieNamed("_gat");
        System.out.println("Is cookie present ? " + SeleniumUtils.checkIfCookieExistsByName(driver, "_gat"));

        System.out.println(driver.manage().getCookies().size());
        driver.manage().deleteAllCookies();
        System.out.println(driver.manage().getCookies().size());
    }

}