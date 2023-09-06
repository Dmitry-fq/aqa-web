package pages;

import org.openqa.selenium.WebDriver;

public class PageBase {

    public WebDriver driver;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }
}
