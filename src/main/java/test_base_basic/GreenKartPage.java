package test_base_basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GreenKartPage {
    private WebDriver driver;

    private By cartBtn = By.cssSelector("img[alt='Cart']");
    private By proceedBtn = By.cssSelector("div[class='cart-preview active'] button");
    private By itemName = By.cssSelector("h4[class='product-name']");

    public GreenKartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCart() {
        driver.findElement(cartBtn).click();
    }

    public GreenKartCartPage clickProceedBtn() {
        driver.findElement(proceedBtn).click();
        return new GreenKartCartPage(driver);
    }

    public String printXpath(String item) {
        return "//h4[contains(text(),'" + item + "')]/parent::div //input[@class='quantity']";
    }

    public void addItems(String item, int quantity) {
        for (int i = 1; i < quantity; i++)
            driver.findElement(By.xpath("//h4[contains(text(),'" + item + "')]/parent::div //a[@class='increment']")).click();
    }

    public void addToCart(String item) {
        driver.findElement(By.xpath("//h4[contains(text(),'" + item + "')]/parent::div/div[@class='product-action']")).click();
    }

    public String getItemQuantity(String item) {
        return driver.findElement(By.xpath("//h4[contains(text(),'" + item + "')]/parent::div //input[@class='quantity']")).getAttribute("value");
    }

    public List<String> getAllItems() {
        return driver.findElements(itemName).stream().map(e -> e.getText()).collect(Collectors.toList());
    }

    public void selectByMap(HashMap<String, Integer> items) {
        List<String> itemsInWebsite = getAllItems();
        for (String item : items.keySet()) {
            for (String webList : itemsInWebsite) {
                if (webList.contains(item)) {
                    addItems(item, items.get(item));
                    addToCart(item);
                }
            }
        }
    }
}
