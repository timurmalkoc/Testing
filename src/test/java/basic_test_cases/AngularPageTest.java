package basic_test_cases;

import basic_base.TestBase;
import org.testng.annotations.Test;
import test_base_basic.AngularPage;

public class AngularPageTest extends TestBase {

    @Test
    public void getText() throws InterruptedException {
        AngularPage page = homePage.clickAngularPage();
        //page.getLabelText();
        page.newTab();
        page.getSizeOfElement();
    }
}
