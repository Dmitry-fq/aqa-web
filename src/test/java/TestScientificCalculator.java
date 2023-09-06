import actions.MainActions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;
import pages.MainPage;
import pages.ScientificCalculatorPage;
import pages.SitemapPage;

public class TestScientificCalculator extends MainActions {

    @Test
    public void testDefaultOperations() {
        MainPage mainPage = new MainPage(driver);
        Actions actions = new Actions(driver);
        openMain();
        openSitemap(mainPage);
        SitemapPage sitemapPage = new SitemapPage(driver);
        openScientificCalculator(sitemapPage);
        ScientificCalculatorPage scientificCalculatorPage = new ScientificCalculatorPage(driver);
        simpleExpressionShouldBeCorrect(scientificCalculatorPage);
        clearFieldInput(scientificCalculatorPage, actions);
        complexExpressionShouldBeCorrect(scientificCalculatorPage, actions);
    }
}
