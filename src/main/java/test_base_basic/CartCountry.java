package test_base_basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CartCountry {
    private WebDriver driver;
    private By country = By.cssSelector("div select");
    private By agreeBtn = By.className("chkAgree");
    private By proceedBtn = By.cssSelector("span[class='errorAlert'] + br + button");

    public CartCountry(WebDriver driver) {
        this.driver = driver;
    }

    public void selectCountry(String count){
        Select select = new Select(driver.findElement(country));
        select.selectByValue(count);
    }

    public String getSelectedCountry(){
        return new Select(driver.findElement(country)).getFirstSelectedOption().getText();
    }

    public void clickAgreeBtn(){
        driver.findElement(agreeBtn).click();
    }

    public void clickProceedBtn(){
        driver.findElement(proceedBtn).click();
    }


}
