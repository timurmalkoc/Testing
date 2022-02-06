package basic_test_cases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class TestNGTest2 {
    @AfterSuite
    public void last(){
        System.out.println("after suit");
    }
    @Test
    public void mobileCarLoanTest(){
        System.out.println("Mobile car loan test");
    }
    @Test (groups = "Smoke")
    public void mobilePersonalInfo(){
        System.out.println("Mobile info Test ------------");
    }
    @Test
    public void apiTest(){
        System.out.println("Api Test");
    }
}
