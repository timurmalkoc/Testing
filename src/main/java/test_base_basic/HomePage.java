package test_base_basic;

import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public DropdownPage dropDownPractice(){
        driver.navigate().to("https://rahulshettyacademy.com/dropdownsPractise/");
        return new DropdownPage(driver);
    }

    public AutomationPracticePage automationPractice(){
        driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
        return new AutomationPracticePage(driver);
    }

    public ClearTripPage clickClearTripPage(){
        driver.navigate().to("https://www.cleartrip.com/");
        return new ClearTripPage(driver);
    }

    public GreenKartPage clickGreenKartPage(){
        driver.navigate().to("https://rahulshettyacademy.com/seleniumPractise/#/");
        return new GreenKartPage(driver);
    }

    public AmazonHome clickAmazonHome(){
        driver.navigate().to("https://www.amazon.com");
        return new AmazonHome(driver);
    }

    public LoginPage clickLogin(){
        driver.navigate().to("https://rahulshettyacademy.com/loginpagePractise/#");
        return new LoginPage(driver);
    }

    public JqueryuiPage clickJqueryui(){
        driver.navigate().to("https://jqueryui.com/droppable/");
        return new JqueryuiPage(driver);
    }

    public Path2USAPage clickPath2USA(){
        driver.navigate().to("https://www.path2usa.com/travel-companions");
        return new Path2USAPage(driver);
    }
}
