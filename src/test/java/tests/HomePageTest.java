package tests;

import Pages.HomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import reports.ReportManager;

public class HomePageTest extends BaseTest {

    @BeforeMethod
    public void setUp(){
        driver.get(utils.ConfigReader.getProperty("baseURL"));
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void testYahooFinance() {

        SoftAssert softAssert = new SoftAssert();  // Create SoftAssert instance
        long threadId = Thread.currentThread().threadId(); // Get Thread ID
        ReportManager.getTest().info("Starting Yahoo Finance Search Test | Thread ID: " + threadId);
        HomePage page = new HomePage();
        page.validate_Auto_Suggest_Message();
        ReportManager.getTest().info("Starting Strock Price Validation | Thread ID: " + threadId);
        page.validate_Stock_Price();
        ReportManager.getTest().info("Print Previous Stock Details | Thread ID: " + threadId);
        page.printAllQuoteStatistics();
        softAssert.assertAll(); // Collect all assertion results and report failures
    }

}
