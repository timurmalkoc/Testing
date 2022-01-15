package basic_test_cases;

import basic_base.TestBase;
import org.testng.annotations.Test;
import test_base_basic.LoginPage;

public class LoginTest extends TestBase {
    @Test
    public void longinTest() throws InterruptedException {
        LoginPage loginPage = homePage.clickLogin();
        loginPage.enterUserName();
        loginPage.enterPassword("learning");
        loginPage.selectAgreement();
        loginPage.clickSigningBtn();

        Thread.sleep(6000);
    }
}
