package basic_test_cases;

import basic_base.TestBase;
import org.testng.annotations.Test;
import test_base_basic.DropdownPage;

import static org.testng.Assert.*;

public class DropdownTest extends TestBase {

    @Test
    public void staticDropdownSelection(){
    DropdownPage staticDropdown = homePage.dropDownPractice();
    String selectedOption = staticDropdown.selectDropdown(3);
    String expected = "USD";
    assertEquals(selectedOption,expected,"Does not match");
    }

    @Test
    public void dropdownSelection2() {
        DropdownPage dropdownPage = homePage.dropDownPractice();
        dropdownPage.setPassengerDropdown(2,3,2);
        String[] result = dropdownPage.getResultTest();
        System.out.println("adult = " + result[0] +
                ", child = " + result[1] +
                ", infant = " + result[2]);
    }

    @Test
    public void dropdownDynamic() throws InterruptedException {
        DropdownPage dropdownPage = homePage.dropDownPractice();
        dropdownPage.selectDynamicDropdown();
        String[] text = dropdownPage.getTextDynamic();
        System.out.println("Departure = " + text[0] +", Arrival = " + text[1]);
    }

    @Test
    public void autoSuggestionTest() throws InterruptedException {
        DropdownPage dropdownPage = homePage.dropDownPractice();
        dropdownPage.autoSuggestDropdown("ind");
    }

    @Test
    public void checkTest() throws InterruptedException {
        DropdownPage dropdownPage = homePage.dropDownPractice();
        dropdownPage.selectCheckBox();
        assertTrue(dropdownPage.isSelected(),"checkbox is not checked");
    }
    @Test
    public void selectDateTest() throws InterruptedException {
        DropdownPage dropdownPage = homePage.dropDownPractice();
        dropdownPage.pickDate();

    }

    @Test
    public void selectRoundTrip(){
        DropdownPage dropdownPage = homePage.dropDownPractice();
        dropdownPage.roundTripClick();
        assertTrue(dropdownPage.isRoundTrip());
    }

    @Test
    public void isDateDisable(){
        DropdownPage dropdownPage = homePage.dropDownPractice();
        dropdownPage.oneWayClick();
        dropdownPage.roundTripClick();
        assertTrue(dropdownPage.isOneWay());
        assertFalse(dropdownPage.isEnableArrivalDate());

    }
}
