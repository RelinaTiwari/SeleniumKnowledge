package base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseTest {
    public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest test;
    
    @BeforeSuite
    public void setUpSuite() {
        System.out.println("Setting up WebDriver and Configuration...");
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("./Reports/TestReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }
    
    @BeforeTest
    public void setUpTest() {
        System.out.println("Initializing Extent Reports...");
    }
    
    @BeforeClass
    public void setUpClass() {
        System.out.println("Launching Browser and navigating to Amazon...");
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
    }
    
    @BeforeMethod
    public void setUpMethod() {
        System.out.println("Navigating to test page...");
    }
    
    @Test
    public void searchProduct() {
        test = extent.createTest("Search Product Test");
        System.out.println("Executing Search Product Test...");
        test.log(Status.PASS, "Search functionality working as expected");
    }
    
    @AfterMethod
    public void tearDownMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(result.getName());
        }
        System.out.println("Logging Test Status...");
    }
    
    @AfterClass
    public void tearDownClass() {
        System.out.println("Closing Browser...");
        driver.quit();
    }
    
    @AfterTest
    public void tearDownTest() {
        System.out.println("Flushing Extent Reports...");
        extent.flush();
    }
    
    @AfterSuite
    public void tearDownSuite() {
        System.out.println("Cleaning up resources...");
    }
    
    public void captureScreenshot(String testName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String dest = "./Screenshots/" + testName + "_" + timestamp + ".png";
        try {
            FileUtils.copyFile(src, new File(dest));
            System.out.println("Screenshot captured for failed test: " + testName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
