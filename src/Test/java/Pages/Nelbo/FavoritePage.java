package Pages.Nelbo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FavoritePage extends BasePage {

    private String addToFavoriteConfirmationSelector = "#maincontent > div.page.messages > div:nth-child(2) > div:nth-child(1) > div > div";
    private String favoritePageTextSelector = "body > main > div > div.page-title-wrapper > div > h1 > span";
    private String addedProductNameSelector = "body > main > div > header > div.bottom-header-content > div > div > div.col-lg-9.col-md-9.col-xs-12 > div > div.table-icon-menu > div.header-wl > a > span.count-wl";
    private String removeFromFavoriteConfirmationTextSelector = "#wishlist-view-form > div.message.info.empty > span";
    private String removeFromFavoriteButtonSelector = "#item_39 > div > div.product-item-inner > div.product-item-actions > a.btn-remove.action.delete > span > i";

    public FavoritePage(WebDriver driver) {
        super(driver);
    }

    public String getAddedProductNameText() {
        return driver.findElement(By.cssSelector(addedProductNameSelector)).getText();
    }

    public String getFavoritePageText() {
        return driver.findElement(By.cssSelector(favoritePageTextSelector)).getText();
    }
    public String getAddText() {
        return driver.findElement(By.cssSelector(addToFavoriteConfirmationSelector)).getText();
    }

    public void removeProductToFavorite() {
        driver.findElement(By.cssSelector(removeFromFavoriteButtonSelector)).click();
    }

    public String getRemoveText() {
        return driver.findElement(By.cssSelector(removeFromFavoriteConfirmationTextSelector)).getText();
    }
}
