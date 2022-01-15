package basic_test_cases;

import basic_base.TestBase;
import org.testng.annotations.Test;
import test_base_basic.CartCountry;
import test_base_basic.GreenKartCartPage;
import test_base_basic.GreenKartPage;

import java.util.HashMap;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class GreenKartTest extends TestBase {

    @Test
    public void addItemTest() throws InterruptedException {
        GreenKartPage greenKart = homePage.clickGreenKartPage();
        // System.out.println(greenKart.printXpath("Cucumber"));
        //Thread.sleep(2000);

        System.out.println();

        HashMap<String,Integer> items = new HashMap<>();
        items.put("Cucumber",3);
        items.put("Brocolli",2);
        items.put("Tomato",5);
        greenKart.selectByMap(items);

//        greenKart.addItems("Cucumber",3);
//        greenKart.addToCart("Cucumber");
//        System.out.println("Cucumber = " + greenKart.getItemQuantity("Cucumber"));
//
//        greenKart.addToCart("Brocolli");
//        System.out.println("Brocolli =" + greenKart.getItemQuantity("Brocolli"));
//
//        greenKart.addItems("Tomato",3);
//        greenKart.addToCart("Tomato");

        //Thread.sleep(2000);

        greenKart.clickCart();
        //Thread.sleep(1000);
        GreenKartCartPage cartPage = greenKart.clickProceedBtn();
        //Thread.sleep(1000);


        cartPage.setPromoCode("rahulshettyacademy");
        boolean promo = cartPage.applyCode();
        // Thread.sleep(5000);
        assertTrue(promo);
        System.out.println("discount = " + cartPage.getDiscount());
        List<String> list = cartPage.getProductNames();
        for (String element:list) {
            String[] item = element.split("-");
            System.out.println("product is -> " + item[0].trim());
        }

        CartCountry country = cartPage.placeOrder();

        country.selectCountry("Turkey");
        System.out.println("selected country = " + country.getSelectedCountry());
        country.clickAgreeBtn();
        country.clickProceedBtn();
        //Thread.sleep(2000);

    }
}
