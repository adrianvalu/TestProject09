package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class MainPage extends BasePage {

    private String userMenuSelector = "body > main > div > header > div.bottom-header-content > div > div > div.col-lg-9.col-md-9.col-xs-12 > div > div.table-icon-menu > div.dropdown.dropdown-toplinks > button > i";
    private String userLoginSelector = "body > main > div > header > div.bottom-header-content > div > div > div.col-lg-9.col-md-9.col-xs-12 > div > div.table-icon-menu > div.dropdown.dropdown-toplinks > div > ul > li.authorization-link > a";
    private String userRegistrationSelector = "body > main > div > header > div.bottom-header-content > div > div > div.col-lg-9.col-md-9.col-xs-12 > div > div.table-icon-menu > div.dropdown.dropdown-toplinks > div > ul > li:nth-child(4) > a";
    private String categoriiSelector = "body > main > div > header > div.bottom-header-content > div > div > div.col-lg-3.col-md-3.col-xs-12 > div > div.widget.megamenu-widget.vertical-menu-widget > div";
    private String acceptCookieSelector = "#btn-cookie-allow > span";
    private String abonareErrSelector = "newsletter-footer-error";

    private String abonareSelector = "#newsletter-validate-detail-footer > div.actions > button > span";
    private String abonareInputSelector = "#newsletter-footer";
    private String searchSelector = "search";
    private String deconectareSelector = "body > main > div > header > div.bottom-header-content > div > div > div.col-lg-9.col-md-9.col-xs-12 > div > div.table-icon-menu > div.dropdown.dropdown-toplinks > div > ul > li.authorization-link > a";


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getCategoriiText() {
        return driver.findElement(By.cssSelector(categoriiSelector)).getText();
    }

    public String getab2() {
        return driver.findElement(By.id(abonareErrSelector)).getText();
    }

    public String getAbonareError() {
        try {
            return driver.findElement(By.id(abonareErrSelector)).getText();
        } catch (NoSuchElementException nse) {
            return "";
        }
    }

    public void hoverButtonInteract() {
        WebElement hoverButton = driver.findElement(By.cssSelector(userMenuSelector));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverButton).build().perform();
    }

    public void hoverButtonInteract2() {
        WebElement hoverButton = driver.findElement(By.cssSelector(abonareSelector));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverButton).build().perform();
    }

    public void goToRegistration() {
        driver.findElement(By.cssSelector(userRegistrationSelector)).click();
    }

    public void goToLogin() {
        driver.findElement(By.cssSelector(userLoginSelector)).click();

    }

    public void goToSearch() {
        driver.findElement(By.id(searchSelector)).click();

    }

    public void acceptCookiesPolicy() {
        driver.findElement(By.cssSelector(acceptCookieSelector)).click();
    }

    public void abonareNewsletter(String email) {
        WebElement emailInput = driver.findElement(By.cssSelector(abonareInputSelector));

        emailInput.clear();
        emailInput.sendKeys(email);

        emailInput.submit();

    }

    public void search(String itemSearch) {
        WebElement searchInput = driver.findElement(By.id(searchSelector));

        searchInput.clear();
        searchInput.sendKeys(itemSearch);

        searchInput.submit();
    }

    public String getDeconectareText() {
        return driver.findElement(By.cssSelector(deconectareSelector)).getText();

    }
}
