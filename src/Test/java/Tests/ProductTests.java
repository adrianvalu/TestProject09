package Tests;

import Pages.*;
import Utils.ExtentTestManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ProductTests extends BaseTest {

    @Test(description = "verify that a product is add to cart", groups = {"smoke"}, priority = 1)
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

    @Test(description = "verify that a product is removed from cart", groups = "regression")
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

    @Test(description = "verify that cart can be emptied")
    public void emptyCartTest(Method method) {
        test = ExtentTestManager.startTest(method.getName(), "verify that cart can be emptied");
        driver.get(baseUrl);
        System.out.println("Browser:" + browser);
        System.out.println("BaseUrl:" + baseUrl);
        LogoutPage lgp = new LogoutPage(driver);
        lgp.addToCart();
        CartPage cp = new CartPage(driver);
        cp.emptyCart();
        Assert.assertEquals(cp.getRemoveProductConfirmationText(), "Nu aveți nici un articol în coșul de cumpărături");
    }

    @Test(description = "verify that you can add a product to favorite")
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

    @Test(description = "verify that you can remove a product from favorite")
    public void removeProductFromFavoriteTest(Method method) {
        test = ExtentTestManager.startTest(method.getName(), "verify that you can remove a product from favorite");
        driver.get(baseUrl);
        System.out.println("Browser:" + browser);
        System.out.println("BaseUrl:" + baseUrl);
        LogoutPage lgp = new LogoutPage(driver);
        lgp.addToFavorite();
        FavoritePage fp = new FavoritePage(driver);
        fp.removeProductToFavorite();
        Assert.assertEquals(fp.getRemoveText(), "Nu aveți nici un articol în lista de dorințe");
    }

    @Test(description = "verify that total price is correct calculated")
    public void verifyTotalProductsPriceTest(Method method) {
        test = ExtentTestManager.startTest(method.getName(), "verify that total price is correct calculated");
        driver.get(baseUrl);
        System.out.println("Browser:" + browser);
        System.out.println("BaseUrl:" + baseUrl);
        LogoutPage lgp = new LogoutPage(driver);
        lgp.addToCart();
        CartPage cp = new CartPage(driver);
        System.out.println("Product price: " + cp.getProductPrice());
        cp.addOneMoreProduct();
        System.out.println("Product quantity: " + cp.getProductQuantity());
        cp.updateCart();
        System.out.println("Total price: " + cp.getTotalPrice());
        Assert.assertEquals(cp.getProductPrice() * cp.getProductQuantity(), cp.getTotalPrice());

    }
}
