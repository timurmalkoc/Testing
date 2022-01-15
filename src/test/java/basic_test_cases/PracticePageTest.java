package basic_test_cases;

import basic_base.TestBase;
import org.testng.annotations.Test;
import test_base_basic.AutomationPracticePage;

import java.io.IOException;

import static org.testng.Assert.*;

public class PracticePageTest extends TestBase {
    @Test
    public void checkBoxTest(){
        AutomationPracticePage practicePage = homePage.automationPractice();
        practicePage.clickCheckBox1();
        assertTrue(practicePage.isChecked());
        practicePage.clickCheckBox1();
        assertFalse(practicePage.isChecked());
        System.out.println("Total number of checkbox are " + practicePage.getTotalNumberOfTextBox());
    }

    @Test
    public void alertTest() {
        AutomationPracticePage practicePage = homePage.automationPractice();
        String name = "ali";
        practicePage.setAlertTextBox(name);
        practicePage.clickAlertBtn();
        String expectedText = "Hello "+ name +", share this practice page and share your knowledge";
        assertEquals(practicePage.getAlertMessage(),expectedText,"Test does not match");
        practicePage.clickAlertOkBtn();
    }

    @Test
    public void numberOfFooterLinkTest(){
        AutomationPracticePage practicePage = homePage.automationPractice();
        int numberOfLink = practicePage.getNumberOfLinkFooter();
        System.out.println("Total number of link = " + numberOfLink);
    }
    @Test
    public void clickFirstColumnLinks() throws InterruptedException {
        AutomationPracticePage practicePage = homePage.automationPractice();
        practicePage.clickLinks();
        practicePage.printPageTitles();
    }
    @Test
    public void scrollPageTest() throws InterruptedException {
        AutomationPracticePage practicePage = homePage.automationPractice();
        practicePage.scrollDown();
        practicePage.scrollDownTable();
        Thread.sleep(5000);
        takeScreenShot("scrollPage");
    }
    @Test
    public void calculateTotalOfNumbersInATableTest(){
        AutomationPracticePage practicePage = homePage.automationPractice();
        assertEquals(practicePage.calculateTotal(),Integer.parseInt(practicePage.getExpected()),"miss calculation");
    }
    @Test
    public void printTable(){
        AutomationPracticePage practicePage = homePage.automationPractice();
        practicePage.printRowsColumns();
    }
    @Test
    public void findBrokenLinksTest() throws IOException {
        AutomationPracticePage practicePage = homePage.automationPractice();
        practicePage.getStatusOfURL();

    }
}
