package Tests.Nelbo;

import Pages.Nelbo.*;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        Assert.assertEquals(fp.getAddToFavoriteConfirmationText(), "Cablu alimentare laptop tip casetofon has been added to your Wish List. Faceți click aici pentru a continua cumpărăturile.");


    }
}
