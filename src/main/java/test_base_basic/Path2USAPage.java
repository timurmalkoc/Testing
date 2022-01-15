package test_base_basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Path2USAPage {
    private WebDriver driver;

    private By travelDate = By.id("travel_date");
    private By datePicker = By.xpath("//table[@class=' table-condensed'] //th[@class='datepicker-switch']");
    private By next = By.xpath("//table[@class=' table-condensed'] //th[@class='next']");

    public Path2USAPage(WebDriver driver) {
        this.driver = driver;
    }



    // Selecting date from a calendar

    public void selectDateOfTravel(String month, String day) {
        driver.findElement(travelDate).click();
        // Select month -------------------->
        while (!driver.findElement(datePicker).getText().contains(month)){
            driver.findElement(next).click();
        }

        // Select day ---------------------->
        List<WebElement> days = driver.findElements(By.className("day"));

        boolean flag = false;

        for (int i=0; i<days.size(); i++){
            if (days.get(i).getText().equals("1"))
                flag = true;
            if (flag && days.get(i).getText().equals(day)){
                days.get(i).click();
                break;
            }
        }


    }
}
