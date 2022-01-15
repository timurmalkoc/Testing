package test_base_basic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonHome {
    private WebDriver driver;
    private By accountBtn = By.id("nav-link-accountList");
    private By searchBox = By.id("twotabsearchtextbox");

    public AmazonHome(WebDriver driver) {
        this.driver = driver;
    }

    public void accountBtnMouseOver(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(accountBtn)).perform();
    }

    public void enterTextIntoSearchBox(String text){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(searchBox)).keyDown(Keys.SHIFT).sendKeys(text).build().perform();
    }
}
