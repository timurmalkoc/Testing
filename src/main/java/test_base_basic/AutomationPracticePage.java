package test_base_basic;

import org.openqa.selenium.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AutomationPracticePage {
    private WebDriver driver;

    private By checkBoxOption1 = By.id("checkBoxOption1");
    private By checkBoxes = By.xpath("//label/input[@type='checkbox']");

    private By alertBtn = By.id("alertbtn");
    private By alertTextBox = By.id("name");

    private By footerLinks = By.xpath("//div[@id='gf-BIG'] //a");
    private By footer = By.id("gf-BIG");

    private By tableAmount = By.cssSelector("div[class='tableFixHead'] td:nth-child(4)");
    private By expectedTotal = By.cssSelector("div[class='totalAmount']");
    private By courseTd = By.xpath("//table[@name='courses'] //td");

    public AutomationPracticePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCheckBox1(){
        driver.findElement(checkBoxOption1).click();
    }

    public Boolean isChecked(){
        return driver.findElement(checkBoxOption1).isSelected();
    }

    public int getTotalNumberOfTextBox(){
        return driver.findElements(checkBoxes).size();
    }

    public void clickAlertBtn(){
        driver.findElement(alertBtn).click();
    }

    public void clickAlertOkBtn(){
        driver.switchTo().alert().accept();
    }

    public String getAlertMessage(){
        return driver.switchTo().alert().getText();
    }

    public void setAlertTextBox(String text){
        driver.findElement(alertTextBox).sendKeys(text);
    }

    public int getNumberOfLinkFooter(){
        return driver.findElement(footer).findElements(By.tagName("a")).size();
        //return driver.findElements(footerLinks).size();
    }
    private List<WebElement> firstColumnLinks(){
        return driver.findElement(footer).findElements(By.xpath("//tr/td[1]/ul //a"));
    }

    public void clickLinks(){
        List<WebElement> elements = firstColumnLinks();
        for(int i=0; i<elements.size();i++){
            elements.get(i).sendKeys(Keys.CONTROL,Keys.ENTER);
        }
    }

    private Set<String> getWindowId(){
        return driver.getWindowHandles();
    }

    private List<String> returnPageTitles(){
        List<String> pageTitles = new ArrayList<>();
        Set<String> pageIds = getWindowId();

        Iterator<String> it = pageIds.iterator();
        it.next(); // skip the parent tab
        while (it.hasNext()){
            pageTitles.add(driver.switchTo().window(it.next()).getTitle());
        }
        return pageTitles;
    }

    public void printPageTitles(){
        List<String> pageTitles;
        pageTitles = returnPageTitles();
        pageTitles.forEach(System.out::println);
    }

    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,500)");


    }

    public void scrollDownTable(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=100");
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        screenshot.getScreenshotAs(OutputType.FILE);
    }

    public int calculateTotal(){
        List<WebElement> elements = driver.findElements(tableAmount);
        int total = 0;

        // List<Integer> amount = elements.stream().map(e->Integer.parseInt(e.getText())).collect(Collectors.toList());
        total = elements.stream().map(e->Integer.parseInt(e.getText())).collect(Collectors.toList())
                .stream().mapToInt(Integer::intValue)
                .sum();
//        amount.forEach(System.out::println);
//        for (int i=0; i<amount.size();i++)
//            total+=amount.get(i);
//        System.out.println("Total = " + total);
        return total;
    }
    public String getExpected(){
        return driver.findElement(expectedTotal).getText().split(" ")[3].trim();
    }

    public void printRowsColumns(){
        List<String> elements = driver.findElements(courseTd).stream().map(e->e.getText()).collect(Collectors.toList());
        String[][] table2 = new String[10][3];
        int row=0,column = 0;

        for (int i=0; i<elements.size();i++){
            if (column == 3) {
                column = 0;
                row++;
            }
            table2[row][column] = elements.get(i);
            column++;
        }

        for (int i=0; i<10; i++){
            for(int j=0; j<3; j++){
                if (j==1)
                    System.out.printf("%-70s",table2[i][j]);
                else
                    System.out.print(table2[i][j]+"\t");
            }
            System.out.println();
        }
    }

    private List<String> getURLFooter(){
        return getFooterElements().stream().map(e->e.getAttribute("href")).collect(Collectors.toList());
    }

    private List<WebElement> getFooterElements(){
       return driver.findElements(footerLinks);
    }

    public void getStatusOfURL() throws IOException {
        List<String> URLs = getURLFooter();
        for (int i=0; i< URLs.size(); i++){
            HttpURLConnection connection = (HttpURLConnection) new URL(URLs.get(i)).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            if (connection.getResponseCode()>400)
                System.out.println("Broken link -> " + getFooterElements().get(i).getText() + " error code = " +connection.getResponseCode());
            }
        }


}
