package tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import reports.ReportManager;
import utils.ConfigReader;
import utils.DriverManager;
import utils.LoggerHelper;

public class BaseTest {
    protected WebDriver driver;
    private static final Logger log = LoggerHelper.getLogger(BaseTest.class);

    @BeforeSuite
    public void setupReport() {
        ReportManager.initReport();
        log.info("Extent Report initialized");
    }

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser, ITestResult result) {
//        String browser = ConfigReader.getProperty("browser");
        DriverManager.initializeDriver(browser);
        driver = DriverManager.getDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        // Initialize ExtentTest for the current test
        String testName = result.getMethod().getMethodName();
        ReportManager.startTest(testName + " | Thread ID: " + Thread.currentThread().getId());
        log.info("Starting test: " + testName + " on browser: " + browser);

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            ReportManager.getTest().fail("Test Failed: " + result.getThrowable().getMessage());
            log.error(STR."Test FAILED: \{result.getMethod().getMethodName()}");
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            ReportManager.getTest().pass("Test Passed Successfully");
            log.info(STR."Test PASSED: \{result.getMethod().getMethodName()}");
        } else {
            ReportManager.getTest().skip("Test Skipped");
            log.warn("Test SKIPPED: " + result.getMethod().getMethodName());
        }

        if (driver != null) {
            DriverManager.quitDriver();
            log.info("Driver closed after test: " + result.getMethod().getMethodName());
        }
    }

    @AfterSuite
    public void flushReport() {
        ReportManager.flushReport();
        log.info("Extent Report flushed and saved.");
    }
}
