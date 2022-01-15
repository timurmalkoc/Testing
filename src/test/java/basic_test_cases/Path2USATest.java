package basic_test_cases;

import basic_base.TestBase;
import org.testng.annotations.Test;
import test_base_basic.Path2USAPage;

public class Path2USATest extends TestBase {

    @Test
    public void selectDate() throws InterruptedException {
        Path2USAPage page = homePage.clickPath2USA();
        page.selectDateOfTravel("April","23");
        Thread.sleep(5000);
    }
}
