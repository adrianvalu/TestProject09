package Pages.Nelbo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{

    private String addToFavoriteSelector = "#product_addtocart_form > div.product-options-bottom > div > div.actions.action-add-to > button.action.towishlist > span";
    private String productPageTextSelector = "body > main > div > div.page-title-wrapper.product > div > h1 > span";

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addProductToFavorite() {
        driver.findElement(By.cssSelector(addToFavoriteSelector)).click();
    }

    public String getProductPageText() {
        return driver.findElement(By.cssSelector(productPageTextSelector)).getText();
    }
}
