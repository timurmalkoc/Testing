package basic_test_cases;

import basic_base.TestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGGroup extends TestBase {
    @Parameters({"URL"})
    @Test (groups = "Smoke", dependsOnMethods = "addItem")
    public void firstTest(String url){
        System.out.println("print url = " + url);
        System.out.println("depend on add item method");
    }

    @Test (groups = "Smoke")
    public void addItem(){
        System.out.println("Items are added !!");
    }

    //@Parameters({"userName","Password"})
    @Test (groups = "Smoke", dataProvider = "getUserInfo", priority = 2)
    public void login(String userName, String password){
        System.out.print("user = "+ userName+"\t\t");
        System.out.println("password = " + password);
    }

    @DataProvider
    public Object[][] getUserInfo(){
        String [][] userinfo = new String[3][2];
        userinfo[0][0] = "ali";     userinfo[0][1]="1234";
        userinfo[1][0] = "veli";    userinfo[1][1]="43534";
        userinfo[2][0] = "kema";    userinfo[2][1]="44444";
        return userinfo;
    }

}
