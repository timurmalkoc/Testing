package basic_test_cases;

import org.testng.annotations.*;

public class TestNGTest {
    @BeforeTest
    public void clearCookies(){
        System.out.println("Cookies are cleared");
    }
    @BeforeClass
    public void setup(){
        System.out.println("Singed in");
    }
    @Test (priority = 2)
    public void secondPriorityTest(){
        System.out.println("Test must run second");
    }
    @Test (groups = "Smoke")
    public void firstPriorityTest(){
        System.out.println("Test must run first");
    }
    @Test
    public void skipTest(){
        System.out.println("Skip Test");
    }

    @AfterClass
    public void tearDown(){
        System.out.println("Sign out");
    }
    @AfterTest
    public void checkReport(){
        System.out.println("Check report");
    }
}
