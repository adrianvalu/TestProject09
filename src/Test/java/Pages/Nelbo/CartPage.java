package Pages.Nelbo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private String cartPageTextSelector = "body > main > div > div.page-title-wrapper > div > h1 > span";
    private String productFromCartSelector = "#shopping-cart-table > tbody > tr > td.col.item > div > strong > a";
    private String removeProductFromCartSelector = "#shopping-cart-table > tbody > tr > td.col.item > div > div > a.action.action-delete > span";
    private String removeProductConfirmationSelector = "#maincontent > div.row > div > div.cart-empty > p:nth-child(1)";
    private String emptyCartSelector = "#empty_cart_button > span";

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
}
