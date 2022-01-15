package test_base_basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class LoginPage {
    private WebDriver driver;
    private By username = By.id("username");
    private By passwordField = By.id("password");
    private By admin = By.className("checkmark");
    private By userType = By.cssSelector("select[class='form-control']");
    private By terms = By.id("terms");
    private By signInBtn = By.id("signInBtn");

    private By getNameLink = By.cssSelector("a[class='blinkingText']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String returnUserName(){
        driver.findElement(getNameLink).click();
        DocumentRequestPage requestPage = new DocumentRequestPage(driver);

        Set<String> windows = driver.getWindowHandles(); //[parent,child]
        Iterator<String> it = windows.iterator();
        String parent = it.next();
        String child = it.next();

        driver.switchTo().window(child); // switch to child

        String user = requestPage.returnUserName();
        user=user.split("at")[1].trim().split(" ")[0]; // splitting text
        System.out.println("user = " + user);

        driver.switchTo().window(parent); // switch to parent
        return user;
    }

    public void enterUserName(){
        driver.findElement(username).sendKeys(returnUserName());
    }
    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void selectAgreement(){
        driver.findElement(terms).click();
    }

    public void clickSigningBtn(){
        driver.findElement(signInBtn).click();
    }
}
