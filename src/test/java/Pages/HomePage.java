package Pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import locators.Locators;
import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import reports.ReportManager;

import java.util.List;

public class HomePage extends BasePage {
    SoftAssert softAssert = new SoftAssert();

//    public void validate_Auto_Suggest_Message() {
//        type(Locators.SEARCH_BOX, Constants.SEARCH_TEXT);
//        waitForElement(Locators.SRCH_BX_FRT_ELE);
//        softAssert.assertEquals(getText(Locators.SRCH_BX_FRT_ELE), Constants.AUTO_SUGG_TEXT, "Auto Suggest Text is not Matching");
//    }

    //For detailed log we can use this method or else we can previous one

    public void validate_Auto_Suggest_Message() {
        ReportManager.getTest().info("Typing search text: " + Constants.SEARCH_TEXT);
        type(Locators.SEARCH_BOX, Constants.SEARCH_TEXT);

        ReportManager.getTest().info("Waiting for first auto-suggested element...");
        waitForElement(Locators.SRCH_BX_FRT_ELE);

        String actualText = getText(Locators.SRCH_BX_FRT_ELE);
        String expectedText = Constants.AUTO_SUGG_TEXT;

        ReportManager.getTest().info("Validating auto-suggest message...");
        ReportManager.getTest().info("Expected: " + expectedText);
        ReportManager.getTest().info("Actual: " + actualText);

        if (actualText.equals(expectedText)) {
            ReportManager.getTest().pass("Auto Suggest Text matches: " + actualText);
        } else {
            ReportManager.getTest().fail("Mismatch! Expected: '" + expectedText + "' but got: '" + actualText );
        }

        softAssert.assertEquals(actualText, expectedText, "Auto Suggest Text is not Matching");
    }


//    public void validate_Stock_Price() {
//        click(Locators.SRCH_BX_FRT_ELE);
//        waitForElement(Locators.STOCK_PRICE);
//        double price = Double.parseDouble(getText(Locators.STOCK_PRICE));
//        softAssert.assertTrue(price > 200, "The Stock Price is not Greater than 200");
//    }

    public void validate_Stock_Price() {
        ReportManager.getTest().info("Clicking on the first auto-suggested element...");
        click(Locators.SRCH_BX_FRT_ELE);

        ReportManager.getTest().info("Waiting for stock price to appear...");
        waitForElement(Locators.STOCK_PRICE);

        String stockPriceText = getText(Locators.STOCK_PRICE);
        double price = Double.parseDouble(stockPriceText);

        ReportManager.getTest().info("Validating stock price...");
        ReportManager.getTest().info("Extracted Stock Price: " + price);

        if (price > 200) {
            ReportManager.getTest().pass("Stock Price validation passed. Price: " + price);
        } else {
            ReportManager.getTest().fail("Stock Price validation failed. Expected > 200 but got " + price);

        }

        softAssert.assertTrue(price > 200, "The Stock Price is not Greater than 200");
    }


    public void printAllQuoteStatistics() {

        ReportManager.getTest().info("Printing Previous stock Details...");
        List<WebElement> listItems = driver.findElements(By.xpath(Locators.PREVIOUS_STOCKS));
        for (int i = 0; i < listItems.size(); i++) {
            System.out.println("Statistics " + (i + 1) + ": " + listItems.get(i).getText());
            ReportManager.getTest().info("Statistics " + (i + 1) + ": " + listItems.get(i).getText());
        }

    }
}
