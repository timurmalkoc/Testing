package basic_test_cases;

import basic_base.TestBase;
import org.testng.annotations.Test;
import test_base_basic.ClearTripPage;

public class ClearTripTest extends TestBase {
    @Test
    public void flightSelectionTest() throws InterruptedException {
        ClearTripPage tripPage = homePage.clickClearTripPage();
        //tripPage.clickOneWayTrip();
        tripPage.departureSelection("new");




        Thread.sleep(3000);
    }
}
