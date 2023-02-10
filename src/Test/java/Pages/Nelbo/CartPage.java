package Pages.Nelbo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private String cartPageTextSelector = "body > main > div > div.page-title-wrapper > div > h1 > span";
    private String productFromCartSelector = "#shopping-cart-table > tbody > tr > td.col.item > div > strong > a";
    private String removeProductFromCartSelector = "#shopping-cart-table > tbody > tr > td.col.item > div > div > a.action.action-delete > span";
    private String removeProductConfirmationSelector = "#maincontent > div.row > div > div.cart-empty > p:nth-child(1)";
    private String emptyCartSelector = "#empty_cart_button > span";
    private String productPriceSelector = "#shopping-cart-table > tbody > tr > td.col.price > span > span > span";
    private String addOneMoreProductSelector = "#shopping-cart-table > tbody > tr > td.col.qty > div > div > span.edit-qty.plus";
    private String updateCartButtonSelector = "#form-validate > div.cart.main.actions > button.action.update.btn.btn-default > span";
    private String quantitySelector = "cart-3810-qty";
    private String totalPriceSelector = "#shopping-cart-table > tbody > tr > td.col.subtotal > span > span > span";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getAddProductConfirmationText() {
        return driver.findElement(By.cssSelector(productFromCartSelector)).getText();
    }

    public String getCartPageText() {
        return driver.findElement(By.cssSelector(cartPageTextSelector)).getText();
    }

    public void removeProductFromCart() {
        driver.findElement(By.cssSelector(removeProductFromCartSelector)).click();
    }

    public String getRemoveProductConfirmationText() {
        return driver.findElement(By.cssSelector(removeProductConfirmationSelector)).getText();
    }

    public void emptyCart() {
        driver.findElement(By.cssSelector(emptyCartSelector)).click();
    }


    public float getProductPrice() {

        String productPriceText = driver.findElement(By.cssSelector(productPriceSelector)).getText();
        String priceText = productPriceText.substring(0, productPriceText.length() - 4);
        float productPrice = Float.parseFloat(priceText.replace(",", "."));
        return productPrice;
    }

    public int getProductQuantity() {

       String productQuantityText = driver.findElement(By.id(quantitySelector)).getAttribute("value");
       int quantityProduct = Integer.parseInt(productQuantityText);
        return quantityProduct;
    }

    public void addOneMoreProduct() {
        driver.findElement(By.cssSelector(addOneMoreProductSelector)).click();
    }

    public void updateCart() {
        driver.findElement(By.cssSelector(updateCartButtonSelector)).click();
    }

    public float getTotalPrice() {

        String totalProductPriceText = driver.findElement(By.cssSelector(totalPriceSelector)).getText();
        String totalPriceText = totalProductPriceText.substring(0, totalProductPriceText.length() - 4);
        float totalPrice = Float.parseFloat(totalPriceText.replace(",", "."));
        return totalPrice;
    }
}
