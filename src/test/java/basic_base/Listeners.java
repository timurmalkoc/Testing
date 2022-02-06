package basic_base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class Listeners extends TestBase implements ITestListener {
    WebDriver driver;

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        TakesScreenshot cam = (TakesScreenshot) driver;
        File file = cam.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(file,new File("resources/failCase/"+result.getTestName()+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
