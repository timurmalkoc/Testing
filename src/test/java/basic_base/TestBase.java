package basic_base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import test_base_basic.HomePage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

public class TestBase {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        int browser = 1;
        if (browser == 1) {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

            ChromeOptions options = new ChromeOptions();
            disableChromeImages(options);

            // Accept SLL certificate and insecure certificate -------------------->
            // DesiredCapabilities capability = new DesiredCapabilities();
            // capability.acceptInsecureCerts();
            // capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
            // capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
            // options.merge(capability);
            // --------------------------------------------------------------------->

            driver = new ChromeDriver(options);
        }
        else if (browser == 2) {
            System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
            driver= new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // goToPage();
        homePage = new HomePage(driver);

    }

    public void goToPage(){
        driver.get("https://rahulshettyacademy.com/");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public static void disableChromeImages(ChromeOptions options){
        HashMap<String,Object> images = new HashMap<>();
        images.put("images",2);
        HashMap<String,Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values",images);
        options.setExperimentalOption("prefs",prefs);
    }
    // @AfterMethod
    public void takeScreenShot(String test){

            TakesScreenshot cam = (TakesScreenshot) driver;
            File screenshot = cam.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot,new File("resources/screenshot/" + test +".png"));
            } catch (IOException e){
                e.printStackTrace();
            }


    }
}
