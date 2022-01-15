package basic_test_cases;

import basic_base.TestBase;
import org.testng.annotations.Test;
import test_base_basic.AmazonHome;

public class AmazonTest extends TestBase {
    @Test
    public void actions() throws InterruptedException {
        AmazonHome amazonHome = homePage.clickAmazonHome();
        amazonHome.accountBtnMouseOver();
        Thread.sleep(5000);
    }

    @Test
    public void actions2() throws InterruptedException {
        AmazonHome amazonHome = homePage.clickAmazonHome();
        amazonHome.enterTextIntoSearchBox("hello kitty");
        Thread.sleep(5000);
    }
}
