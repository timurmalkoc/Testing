package test_base_basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class GreenKartCartPage {
    private WebDriver driver;

    private By productName = By.cssSelector("tbody tr td p[class='product-name']");
    private By promoCode = By.className("promoCode");
    private By promoBtn = By.className("promoBtn");
    private By discount = By.className("discountPerc");
    private By placeOrder = By.cssSelector("span[class='discountAmt'] +br +br + button");
    private By promoCodeConfirm = By.className("promoInfo");

    public GreenKartCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getProductNames(){
        List<WebElement> elements = driver.findElements(productName);
        return elements.stream().map(e->e.getText().trim()).collect(Collectors.toList());
    }

    public void setPromoCode(String code){
        driver.findElement(promoCode).sendKeys(code);
    }

    public boolean applyCode(){
        driver.findElement(promoBtn).click();
        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(promoCodeConfirm));
        if (driver.findElement(promoCodeConfirm).getText().contains("Code applied"))
            return true;
        return false;
    }

    public String getDiscount(){
        return driver.findElement(discount).getText();
    }

    public CartCountry placeOrder(){
        driver.findElement(placeOrder).click();
        return new CartCountry(driver);
    }


}
