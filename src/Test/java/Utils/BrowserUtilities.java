package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
import java.util.regex.Pattern;

public class BrowserUtilities {

    public static WebElement waitForGenericElement(WebDriver driver, By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static Boolean waitForTextOnSite(WebDriver driver, By locator, int timeout, String pattern) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        Pattern patt = Pattern.compile(pattern);
        return wait.until(ExpectedConditions.textMatches(locator,patt));
    }

    public static String createRandomString(int charCount) {
        StringBuilder sb = new StringBuilder();
        String charset = "abcdefghijklmnopqrstuvwxyz";
        charset += charset.toUpperCase();
        for (int i = 0; i < charCount; i++) {
            Random r = new Random();
            char x = charset.toCharArray()[r.nextInt(charset.length())];
            sb.append(x);
        }
        return sb.toString();
    }

}