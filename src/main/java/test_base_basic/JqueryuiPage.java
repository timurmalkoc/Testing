package test_base_basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class JqueryuiPage {
    private WebDriver driver;
    private By placeToDrop = By.id("droppable");
    private By object = By.id("draggable");
    private By frame = By.className("demo-frame");
    private By message = By.cssSelector("div[id='droppable'] p");


    public JqueryuiPage(WebDriver driver) {
        this.driver = driver;
    }

    public String dragDropItem(){
        driver.switchTo().frame(driver.findElement(frame));     // iframe switch

        Actions action = new Actions(driver);
        action.dragAndDrop(driver.findElement(object),driver.findElement(placeToDrop)).build().perform();
        String text = driver.findElement(message).getText();
        driver.switchTo().parentFrame();// Back to parent frame
        return text;
    }

}
