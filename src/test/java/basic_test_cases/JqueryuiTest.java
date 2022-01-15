package basic_test_cases;

import basic_base.TestBase;
import org.testng.annotations.Test;
import test_base_basic.JqueryuiPage;

import static org.testng.Assert.assertEquals;

public class JqueryuiTest extends TestBase {
    @Test
    public void dragDropTest() throws InterruptedException {
        JqueryuiPage page = homePage.clickJqueryui();
        String text = page.dragDropItem();
        String confMessage = "Dropped!";
        assertEquals(text,confMessage,"Doesn't match");
        Thread.sleep(3000);
    }
}
