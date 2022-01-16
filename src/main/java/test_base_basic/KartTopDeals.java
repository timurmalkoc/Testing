package test_base_basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class KartTopDeals {
    private WebDriver driver;
    private By tableProductNames = By.xpath("//tr/td[1]");
    private By tableProductPrices = By.xpath("following-sibling::td[1]");
    private By sortBtn = By.xpath("//tr/th[1]");
    private By nextBtn = By.xpath("//a[@aria-label='Next']");
    private By searchBox = By.id("search-field");

    public KartTopDeals(WebDriver driver) {
        this.driver = driver;
    }

    public void getProductName() throws InterruptedException {
        switchTab();
        driver.findElement(sortBtn).click();
        List<WebElement> itemNames = driver.findElements(tableProductNames);

        System.out.println("=========== Top Deal Items ============");

        itemNames.stream()
                .map(WebElement::getText)
                .sorted()
                .collect(Collectors.toList())
                .forEach(System.out::println);


    }

    private void switchTab() throws InterruptedException {
        List<String> tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public void getPrice(String item) throws InterruptedException {
        switchTab();
        List<String> price;
        do {
            List<WebElement> items = driver.findElements(tableProductNames);
            items.stream().forEach(e -> System.out.println(e.getText()));

            price = items.stream().filter(e -> e.getText().equalsIgnoreCase(item))
                            .map(e -> getPriceVeggie(e)).collect(Collectors.toList());

            if (items.stream().anyMatch(e->e.getText().equalsIgnoreCase(item)))
                break;
            driver.findElement(nextBtn).click();
        }while (!driver.findElement(nextBtn).getAttribute("class").equals("disabled"));
        System.out.print(item + " price = ");
        price.stream().forEach(System.out::println);
    }

    private String getPriceVeggie(WebElement s){
        return s.findElement(tableProductPrices).getText();
    }

    public void getSearchResult(String item) throws InterruptedException {
        switchTab();
        driver.findElement(searchBox).sendKeys(item);

        List<WebElement> items = driver.findElements(tableProductNames);
        int count = items.size();

        int matchItem =
                (int) items.stream().filter(e->e.getText().equalsIgnoreCase(item))
                        .count();

        if (count == matchItem)
            System.out.println("Search function works well !! ");
    }
}
