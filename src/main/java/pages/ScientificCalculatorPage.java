package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScientificCalculatorPage extends PageBase {

    @FindBy(xpath = "//*[@id=\"sciout\"]/div[3]/div[3]/span[3]")
    public WebElement button3;

    @FindBy(xpath = "//*[@id=\"sciout\"]/div[3]/div[1]/span[2]")
    public WebElement button8;

    @FindBy(xpath = "//*[@id=\"sciout\"]/div[3]/div[3]/span[4]")
    public WebElement buttonMultiplication;

    @FindBy(xpath = "//*[@id=\"sciout\"]/div[2]/div[5]/span[1]")
    public WebElement buttonLeftParenthesis;

    @FindBy(xpath = "//*[@id=\"sciout\"]/div[2]/div[5]/span[2]")
    public WebElement buttonRightParenthesis;

    @FindBy(xpath = "//*[@id=\"sciout\"]/div[3]/div[2]/span[4]")
    public WebElement buttonMinus;

    @FindBy(id = "sciOutPut")
    public WebElement fieldResult;

    @FindBy(id = "sciInPut")
    public WebElement fieldInput;

    @FindBy(xpath = "//*[@id=\"sciout\"]/div[2]/div[4]/span[5]")
    public WebElement buttonLog;

    @FindBy(xpath = "//*[@id=\"sciout\"]/div[2]/div[4]/span[4]")
    public WebElement buttonLn;

    @FindBy(xpath = "//*[@id=\"sciout\"]/div[2]/div[4]/span[1]")
    public WebElement buttonRadical;

    public ScientificCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
