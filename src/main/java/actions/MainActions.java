package actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.MainPage;
import pages.ScientificCalculatorPage;
import pages.SitemapPage;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainActions extends ActionsBase {

    public void openMain() {
        driver.get("https://www.calculator.net/");
    }

    public void openSitemap(MainPage mainPage) {
        scrollToElement(driver, mainPage.allCalculatorsButton);
        mainPage.allCalculatorsButton.click();
    }

    public void openScientificCalculator(SitemapPage sitemapPage) {
        scrollToElement(driver, sitemapPage.scientificCalculator);
        sitemapPage.scientificCalculator.click();
    }

    public void clearFieldInput(ScientificCalculatorPage scientificCalculatorPage, Actions actions) {
        String fieldInput = scientificCalculatorPage.fieldInput.getText().trim();
        int countSymbols = fieldInput.replace(" ", "").length();
        for (int i = 0; i < countSymbols; i++) {
            actions.sendKeys(Keys.BACK_SPACE).build().perform();
        }
    }

    public void simpleExpressionShouldBeCorrect(ScientificCalculatorPage scientificCalculatorPage) {
        scientificCalculatorPage.button8.click();
        scientificCalculatorPage.buttonMultiplication.click();
        scientificCalculatorPage.buttonLeftParenthesis.click();
        scientificCalculatorPage.button8.click();
        scientificCalculatorPage.buttonMinus.click();
        scientificCalculatorPage.button3.click();
        scientificCalculatorPage.buttonRightParenthesis.click();
        int expectedResult = 8 * (8 - 3);
        int actualResult = Integer.parseInt(scientificCalculatorPage.fieldResult.getText().trim());

        assertEquals(expectedResult, actualResult);
    }

    public void complexExpressionShouldBeCorrect(ScientificCalculatorPage scientificCalculatorPage, Actions actions) {
        scientificCalculatorPage.buttonLog.click();
        actions.sendKeys(Keys.NUMPAD5).build().perform();
        actions.sendKeys(Keys.NUMPAD6).build().perform();
        actions.sendKeys(")").build().perform();
        actions.sendKeys("/").build().perform();
        scientificCalculatorPage.buttonLn.click();
        actions.sendKeys(Keys.NUMPAD5).build().perform();
        actions.sendKeys(Keys.NUMPAD6).build().perform();
        actions.sendKeys(")").build().perform();
        actions.sendKeys(Keys.MULTIPLY).build().perform();
        actions.sendKeys("(").build().perform();
        actions.sendKeys(Keys.NUMPAD4).build().perform();
        scientificCalculatorPage.buttonRadical.click();
        actions.sendKeys(Keys.NUMPAD5).build().perform();
        actions.sendKeys(Keys.MULTIPLY).build().perform();
        actions.sendKeys(Keys.NUMPAD1).build().perform();
        actions.sendKeys(Keys.NUMPAD0).build().perform();
        actions.sendKeys(")").build().perform();
        actions.sendKeys(Keys.ENTER).build().perform();

        BigDecimal expectedResult = BigDecimal.valueOf(Math.log10(56) / Math.log(56) * (Math.pow(4, 1.0 / 5.0) * 10));
        BigDecimal expectedResultRoundUp = expectedResult.setScale(10, RoundingMode.UP);
        BigDecimal actualResult = BigDecimal.valueOf(
                Double.parseDouble(scientificCalculatorPage.fieldResult.getText().trim())
        );
        assertEquals(expectedResultRoundUp, actualResult);
    }
}
