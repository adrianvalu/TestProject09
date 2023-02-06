package Pages.Nelbo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IncarcatoareLaptopuriPage extends BasePage {

    private String cabluTipCasetofonSelector = "#product-wrapper > ol > li:nth-child(1) > div.product.details.product-item-details > h5 > a";
    private String adaugaInCosSelector = "#product-wrapper > ol > li:nth-child(1) > div.product.details.product-item-details > div:nth-child(3) > form > button > span.text";
private String incarcatoareLaptopuriPageTextSelector = "#page-title-heading > span";
    public IncarcatoareLaptopuriPage(WebDriver driver) {
        super(driver);
    }

    public String getIncarcatoareLaptopuriPageText() {
        return driver.findElement(By.cssSelector(incarcatoareLaptopuriPageTextSelector)).getText();
    }

    public void addProductToCart() {
        driver.findElement(By.cssSelector(adaugaInCosSelector)).click();
    }

    public void goToProductPage() {
        driver.findElement(By.cssSelector(cabluTipCasetofonSelector)).click();
    }


    }
