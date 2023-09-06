package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SitemapPage extends PageBase {

    @FindBy(xpath = "//*[@id=\"sl3\"]/table/tbody/tr[1]/td[1]/a")
    public WebElement scientificCalculator;

    public SitemapPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
