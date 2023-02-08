package Pages.Nelbo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class LogoutPage extends BasePage {

    private String deconectareSelector = "body > main > div > header > div.bottom-header-content > div > div > div.col-lg-9.col-md-9.col-xs-12 > div > div.table-icon-menu > div.dropdown.dropdown-toplinks > div > ul > li.authorization-link > a";
    private String userMenuSelector = "body > main > div > header > div.bottom-header-content > div > div > div.col-lg-9.col-md-9.col-xs-12 > div > div.table-icon-menu > div.dropdown.dropdown-toplinks > button > i";
    private String logoutConfirmationSelector = "#maincontent > div.row > div > div.message.success > div";
    private String incarcatoarelaptopuriSelector = "#vertical-menu-2 > li:nth-child(3) > a > span";

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    public void hoverButtonInteract() {
        WebElement hoverButton = driver.findElement(By.cssSelector(userMenuSelector));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverButton).build().perform();
    }

    public void deconectare() {
        driver.findElement(By.cssSelector(deconectareSelector)).click();

    }

    public String getLogoutConfirmationText() {
        return driver.findElement(By.cssSelector(logoutConfirmationSelector)).getText();
    }

    public void logare() {
        MainPage mp = new MainPage(driver);
        Assert.assertEquals(mp.getCategoriiText(), "CATEGORII");
        mp.acceptCookiesPolicy();
        mp.hoverButtonInteract();
        mp.goToLogin();
        LoginPage lp = new LoginPage(driver);
        Assert.assertEquals(lp.getLoginPageText(), "Conectare client");
        lp.loginAccount("elena_tiuca@yahoo.com", "test123!");
    }

    public void addToCart() {
        LogoutPage lgp = new LogoutPage(driver);
        lgp.logare();
        lgp.goToInarcatoareLaptopuri();
        IncarcatoareLaptopuriPage ilp = new IncarcatoareLaptopuriPage(driver);
        Assert.assertEquals(ilp.getIncarcatoareLaptopuriPageText(), "Incarcatoare laptopuri");
        ilp.addProductToCart();
        CartPage cp = new CartPage(driver);
        Assert.assertEquals(cp.getCartPageText(), "Coș de cumpărături");
        Assert.assertEquals(cp.getAddProductConfirmationText(), "Cablu alimentare laptop tip casetofon");
    }

    public void goToInarcatoareLaptopuri() {
        driver.findElement(By.cssSelector(incarcatoarelaptopuriSelector)).click();

    }

    public void addToFavorite() {

        LogoutPage lgp = new LogoutPage(driver);
        lgp.logare();
        lgp.goToInarcatoareLaptopuri();
        IncarcatoareLaptopuriPage ilp = new IncarcatoareLaptopuriPage(driver);
        Assert.assertEquals(ilp.getIncarcatoareLaptopuriPageText(), "Incarcatoare laptopuri");
        ilp.goToProductPage();
        ProductPage pp = new ProductPage(driver);
        Assert.assertEquals(pp.getProductPageText(), "Cablu alimentare laptop tip casetofon");
        pp.addProductToFavorite();
        FavoritePage fp = new FavoritePage(driver);
        Assert.assertEquals(fp.getFavoritePageText(), "Lista Mea de dorințe");
        Assert.assertEquals(fp.getAddedProductNameText(), "1");
    }
}
