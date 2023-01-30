package Pages.Nelbo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    private String memorySelector = "#narrow-by-list > div:nth-child(1) > dd > ol > li:nth-child(3) > a";
    private String countItemSelector = "#narrow-by-list > div:nth-child(1) > dd > ol > li:nth-child(3) > a > span";
    private String searchErrorSelector = "#maincontent > div.row > div.column.main.col-lg-9.col-md-9.col-sm-12.col-xs-12.pull-right > div.message.notice > div";




    public String getMemoryText() {
        return driver.findElement(By.cssSelector(memorySelector)).getText();

    }

    public String getSearchErrorText() {
        return driver.findElement(By.cssSelector(searchErrorSelector)).getText();

    }




    public SearchPage(WebDriver driver) {
        super(driver);
    }
}
