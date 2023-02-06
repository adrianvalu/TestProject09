package Tests.Nelbo;

import Pages.Nelbo.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ProductTests extends BaseTest {

    @Test(description = "verify that a product is add to cart", groups = "Regression")
    public void addProductToCartTest() {

        driver.get(baseUrl);
        System.out.println("Browser:" + browser);
        System.out.println("BaseUrl:" + baseUrl);
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
    @Test(groups = "Smoke", description = "verify that a product is removed from cart")
    public void removeProductFromCartTest() {

        driver.get(baseUrl);
        System.out.println("Browser:" + browser);
        System.out.println("BaseUrl:" + baseUrl);
        LogoutPage lgp = new LogoutPage(driver);
        lgp.addToCart();
        CartPage cp = new CartPage(driver);
        cp.removeProductFromCart();
        Assert.assertEquals(cp.getRemoveProductConfirmationText(), "Nu aveți nici un articol în coșul de cumpărături");

    }

    @Test(description = "verify that cart is emptied")
    public void emptyCartTest() {

        driver.get(baseUrl);
        System.out.println("Browser:" + browser);
        System.out.println("BaseUrl:" + baseUrl);
        LogoutPage lgp = new LogoutPage(driver);
        lgp.addToCart();
        CartPage cp = new CartPage(driver);
        cp.emptyCart();
        Assert.assertEquals(cp.getRemoveProductConfirmationText(), "Nu aveți nici un articol în coșul de cumpărături");
    }

    @Test
    public void addProductToFavoriteTest() {

        driver.get(baseUrl);
        System.out.println("Browser:" + browser);
        System.out.println("BaseUrl:" + baseUrl);
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

    @Test
    public void removeProductFromFavoriteTest() {

        driver.get(baseUrl);
        System.out.println("Browser:" + browser);
        System.out.println("BaseUrl:" + baseUrl);
        LogoutPage lgp = new LogoutPage(driver);
        lgp.addToFavorite();
        FavoritePage fp = new FavoritePage(driver);
        fp.removeProductToFavorite();
        Assert.assertEquals(fp.getRemoveText(), "Nu aveți nici un articol în lista de dorințe");
    }

    @Test
    public void verifyTotalProductsPriceTest() {

        driver.get(baseUrl);
        System.out.println("Browser:" + browser);
        System.out.println("BaseUrl:" + baseUrl);
        LogoutPage lgp = new LogoutPage(driver);
        lgp.addToCart();
        CartPage cp = new CartPage(driver);
        System.out.println(cp.getProductPrice());
        cp.addOneMoreProduct();
        cp.updateCart();
        System.out.println(cp.getTotalPrice());
        Assert.assertEquals(cp.getProductPrice()*2, cp.getTotalPrice());

    }
}
