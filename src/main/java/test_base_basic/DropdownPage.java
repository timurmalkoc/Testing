package test_base_basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {
    private WebDriver driver;
    private By dropdownCurrency = By.id("ctl00_mainContent_DropDownListCurrency");
    private By passengerDropdown = By.id("divpaxinfo");
    private By adultAddBtn = By.id("hrefIncAdt");
    private By adultDecBtn = By.id("hrefDecAdt");
    private By adultTextBox = By.id("spanAudlt");
    private By childAddBtn = By.id("hrefIncChd");
    private By childDecBtn = By.id("hrefDecChd");
    private By childTextBox = By.id("spanChild");
    private By infantAddBtn = By.id("hrefIncInf");
    private By infantDecBtn = By.id("hrefDecInf");
    private By infantTextBox = By.id("spanInfant");
    private By doneBtn = By.id("btnclosepaxoption");

    private By departureDropdown = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By arrivalDropdown = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By BLR_Departure = By.xpath("//a[@value='BLR']");
    private By BHO_Arrival = By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BHO']");

    private By autoDropdown = By.id("autosuggest");
    private By options = By.xpath("//li[@class='ui-menu-item']");

    private By checkBoxFamilyFriend = By.id("ctl00_mainContent_chk_friendsandfamily");

    private By departureCalendar = By.id("ctl00_mainContent_view_date1");
    private By arrivalCalendar = By.id("ctl00_mainContent_view_date2");
    private By departureDayPick = By.xpath("//div[contains(@class,'ui-datepicker-group-first')] //a[text()='20']");
    private By arrivalDayPick = By.xpath("//div[contains(@class,'ui-datepicker-multi-2')] //a[text()='31']");
    private By arrivalDateEnable = By.id("//div[@id='Div1']");

    private By oneWay = By.id("ctl00_mainContent_rbtnl_Trip_0");
    private By roundTrip = By.id("ctl00_mainContent_rbtnl_Trip_1");
    private By multicity = By.id("ctl00_mainContent_rbtnl_Trip_2");

    Select select;
    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    public String selectDropdown(int index){
        select = new Select(driver.findElement(dropdownCurrency));
        select.selectByIndex(index);
        return select.getFirstSelectedOption().getText();

    }

    // passenger drop down

    public void setPassengerDropdown(int adult, int child, int infant){
        driver.findElement(passengerDropdown).click();
        setAdult(adult);
        setChild(child);
        setInfant(infant);
    }

    private void setAdult(int adult){
        for (int i=1; i<adult; i++)
            driver.findElement(adultAddBtn).click();
    }

    private void setChild(int child){
        for (int i=0; i<child; i++)
            driver.findElement(childAddBtn).click();
    }

    private void setInfant(int infant){
        for (int i=0; i<infant; i++)
            driver.findElement(infantAddBtn).click();
    }

    public String[] getResultTest(){
        String[] result = new String[3];
        result[0]=driver.findElement(adultTextBox).getText();
        result[1]=driver.findElement(childTextBox).getText();
        result[2]=driver.findElement(adultTextBox).getText();
        return result;
    }

    public void selectDynamicDropdown() throws InterruptedException {
        driver.findElement(departureDropdown).click();
        driver.findElement(BLR_Departure).click();
        driver.findElement(arrivalDropdown).click();
        Thread.sleep(2000);
        driver.findElement(BHO_Arrival).click();
        //driver.findElement(By.xpath("(//a[@value='MAA'])[2]"))
        Thread.sleep(4000);
    }

    public String[] getTextDynamic(){
        String[] text = new String[2];
        text[0]= driver.findElement(departureDropdown).getAttribute("selectedvalue");
        text[1]= driver.findElement(arrivalDropdown).getAttribute("selectedvalue");
        return text;
    }

    public void autoSuggestDropdown(String partialText) throws InterruptedException {
        driver.findElement(autoDropdown).sendKeys(partialText);
        Thread.sleep(1000);
        List<String> list = getSelectedOption(options);
        list.forEach(System.out::println);
        List<WebElement> webList = getWebelements(options);
        webList.get(2).click();
        System.out.println("selected text = " + driver.findElement(autoDropdown).getAttribute("value"));
        Thread.sleep(3000);
      // -------------------------
        /*List<WebElement> options =driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for(WebElement option :options)
        {
            if(option.getText().equalsIgnoreCase("India"))
            {
                option.click();
                break;
            }
        }*/
    }

    private List<String> getSelectedOption(By element){
        List<WebElement> selectedElements = driver.findElements(element);
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    private List<WebElement> getWebelements(By element){
        List<WebElement> selectedElements = driver.findElements(element);
        return selectedElements;
    }



    public void selectCheckBox() throws InterruptedException {
        driver.findElement(checkBoxFamilyFriend).click();
        //driver.findElement(checkBoxSenior).click();
        Thread.sleep(3000);
    }

    public Boolean isSelected(){
        return driver.findElement(checkBoxFamilyFriend).isSelected();
    }

    public void pickDate() throws InterruptedException {
        driver.findElement(departureCalendar).click();
        driver.findElement(departureDayPick).click();
        driver.findElement(arrivalCalendar).click();
        driver.findElement(arrivalDayPick).click();
        Thread.sleep(3000);
        System.out.println("departure = " + driver.findElement(By.id("view_fulldate_id_1")).getText());
        System.out.println("arrival = " + driver.findElement(By.id("view_fulldate_id_2")).getText());
    }

    public void roundTripClick(){
        driver.findElement(roundTrip).click();
    }
    public void oneWayClick(){
        driver.findElement(roundTrip).click();
    }
    public boolean isRoundTrip(){
        return driver.findElement(roundTrip).isSelected();
    }
    public boolean isOneWay(){
        return driver.findElement(roundTrip).isSelected();
    }
    public boolean isEnableArrivalDate(){
        if (driver.findElement(arrivalDateEnable).getAttribute("opacity") == "1")
            return true;
        return false;
    }
}
