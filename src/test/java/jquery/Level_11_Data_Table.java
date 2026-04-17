package jquery;

import core.BasePage;
import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGeneration;
import pageObjects.jquery.HomePO;

public class Level_11_Data_Table extends BaseTest {
    private WebDriver driver;
    private BasePage basePage = BasePage.getBasePage();

    @Parameters ({"Browser","Url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        homePage = PageGeneration.getPage(HomePO.class, driver);
        homePage.sleepInSecond(15);
    }

    //@Test
    public void DataTable_01_Paging(){
        homePage.openPageByNumber("9");
        Assert.assertTrue(homePage.isPageActivedByNumber("9"));

    }

    //@Test
    public void DataTable_02_Search() {
        homePage.enterToTextboxByHeaderName("Females","276880");
        homePage.enterToTextboxByHeaderName("Country","Angola");
        homePage.enterToTextboxByHeaderName("Males","276472");
        homePage.enterToTextboxByHeaderName("Total","553353");

        Assert.assertTrue(homePage.isRowActiveByValue("276880","Angola","276472","553353"));

        homePage.refreshCurrentPage(driver);
    }

    //@Test
    public void DataTable_03_Action() {
        // icon edit/delete/link
        homePage.clickToIconByCountryName("Angola","remove");
        homePage.sleepInSecond(2);

        homePage.clickToIconByCountryName("Albania","remove");
        homePage.sleepInSecond(2);

        homePage.clickToIconByCountryName("Australia","edit");
        homePage.sleepInSecond(2);
    }

    //@Test
    public void DataTable_04_Index() {
        homePage.enterToTextboxByColumnNameAndRowIndex("Contact Person","2","John");
        homePage.sleepInSecond(2);

        homePage.enterToTextboxByColumnNameAndRowIndex("Company","2","White Horse");
        homePage.sleepInSecond(2);

        homePage.enterToTextboxByColumnNameAndRowIndex("Order Placed","3","15");
        homePage.sleepInSecond(2);

        homePage.selectToDropdownByColumnNameAndRowIndex("Country","1","Malaysia");

        homePage.selectToDropdownByColumnNameAndRowIndex("Country","2","Hong Kong");

        homePage.selectToDropdownByColumnNameAndRowIndex("Country","3","United Kingdom");

    }

    @Test
    public void DataTable_05_GetAll() {
        homePage.getAllValueByColumnName("Country");

        homePage.getAllValueByColumnName("Total");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private HomePO homePage;

}
