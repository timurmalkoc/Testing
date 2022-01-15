package test_base_basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DocumentRequestPage {
    private WebDriver driver;
    private By userName = By.xpath("//p[contains(@class,'im-para red')]");

    public DocumentRequestPage(WebDriver driver) {
        this.driver = driver;
    }

    public String returnUserName(){
        return driver.findElement(userName).getText();
    }
}
