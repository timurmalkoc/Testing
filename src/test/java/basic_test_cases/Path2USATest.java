package basic_test_cases;

import basic_base.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test_base_basic.Path2USAPage;

public class Path2USATest extends TestBase {
    ExtentReports extent;
    @BeforeTest
    public void config(){
        String path = "reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation");
        reporter.config().setDocumentTitle("Test Result");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Timur");

    }
    @Test
    public void selectDate() throws InterruptedException {
        extent.createTest("select date");
        Path2USAPage page = homePage.clickPath2USA();
        page.selectDateOfTravel("April","23");
        Thread.sleep(5000);
        extent.flush();
    }
    @Test
    public void fail(){
        ExtentTest test = extent.createTest("fail test case");
        test.fail("Test Fail");
        extent.flush();
    }
}
