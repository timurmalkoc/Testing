package test_base_basic;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.locators.RelativeLocator.with;


public class AngularPage {
    private WebDriver driver;
    private By textField = By.cssSelector("input[name='name'][class*='form-control']");
    private By DOBFiled = By.cssSelector("label[for='dateofBirth']");
    private By twoWayDataTextBox = By.xpath("//h4/input[@name='name'][contains(@class,'ng-valid')]");

    public AngularPage(WebDriver driver) {
        this.driver = driver;
    }

    // *********** Selenium 4 feature ***************

    public void getLabelText() throws InterruptedException {
        WebElement nameBox = driver.findElement(textField);
        String labelText = driver.findElement(with(By.tagName("label")).above(nameBox)).getText();
        System.out.println(labelText);

        WebElement DOB = driver.findElement(DOBFiled);
        driver.findElement(with(By.tagName("input")).below(DOB)).click();

        Thread.sleep(3000);
    }


    // new tab

    public void newTab() throws InterruptedException {
        driver.switchTo().newWindow(WindowType.TAB).get("https://rahulshettyacademy.com/#/index");
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        String parent = iterator.next();
        String child = iterator.next();

        driver.switchTo().window(child);
        List<String> courses = driver.findElements(By.cssSelector("h2 a[href*='com/p/']"))
                .stream().map(e->e.getText())
                .collect(Collectors.toList());

        driver.switchTo().window(parent);

        WebElement textElement = driver.findElement(textField);
        textElement.sendKeys(courses.get(1));
        System.out.println(courses.get(1));

        // Screenshot ----------------------------------------------------------
        File textShot = textElement.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(textShot,new File("resources/screenshot/test.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void getSizeOfElement(){
        WebElement textElement = driver.findElement(textField);

        System.out.println("Height = " + textElement.getRect().getHeight());
        System.out.println("Width  = " + textElement.getRect().getWidth());
    }

}
