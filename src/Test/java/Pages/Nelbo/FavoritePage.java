package Pages.Nelbo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FavoritePage extends BasePage {

    private String addToFavoriteConfirmationSelector = "#maincontent > div.page.messages > div:nth-child(2) > div:nth-child(1) > div > div";

    public FavoritePage(WebDriver driver) {
        super(driver);
    }

    public String getAddToFavoriteConfirmationText() {
        return driver.findElement(By.cssSelector(addToFavoriteConfirmationSelector)).getText();
    }
}
