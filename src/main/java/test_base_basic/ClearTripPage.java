package test_base_basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ClearTripPage {
    private WebDriver driver;

    private By oneWay = By.cssSelector("[class*='radio__secondary']");
    private By departure = By.xpath("//input[contains(@class,'field')]");
    private By arrival = By.xpath("//input[@class='field bw-1 bs-solid w-100p p-2 box-border br-4 fs-2 c-neutral-900 h-8 bc-neutral-100 c-neutral-900 focus:bc-secondary-500 flex flex-middle flex-between t-all fs-2 focus:bc-secondary-500 bg-transparent bc-secondary-500 pr-2 pl-3 pt-2 pb-2 ba br-4 h-8']");
    private By departureList = By.xpath("//*[@class='bg-white br-4 elevation-5 p-1 p-absolute mt-1 z-50 l-0'] //li/p");

    public ClearTripPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOneWayTrip() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(oneWay).click();
    }

    public void departureSelection(String test) throws InterruptedException {
        driver.findElement(departure).sendKeys(test);
        List<WebElement> elements = driver.findElements(departureList);
        for (WebElement element:elements) {
            if (element.getText().contains("JFK")) {
                System.out.println(element.getText());
                element.click();
                break;
            }
        }
    }
}
