package employee;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_02_BasePage_I {

    //Declare (Khai bao)
    private WebDriver driver;
    private BasePage basePage;
    String firstName, lastName, fullName, emailAddress, password, employeeID, passportNumber, passportComment;

    @BeforeClass
    public void beforeClass() {

        // Init (khoi tao)
        driver = new FirefoxDriver();
        basePage = new BasePage();
        // dùng được những thuộc tính và phương thức của class đó

        firstName = "Peter";
        lastName = "Crouch";
        fullName = firstName + " " + lastName;
        emailAddress = "peter" + new Random().nextInt(9999) + "@hotmail.com";
        password = "Testing111###";
        passportNumber = "43176122";
        passportComment = "Assigned Imigration\nRecords";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void Employee_01_NewEmployee() throws InterruptedException {
        basePage.openPageUrl(driver, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Login
        basePage.sendkeyToElement(driver, "//input[@name='username']", "automationfc");
        basePage.sendkeyToElement(driver, "//input[@name='password']", "Auto222$$$");
        basePage.clickToElement(driver, "//button[contains(@class,'orangehrm-login-button')]");

        // Wait for all Loading icon disappear
        Assert.assertTrue(basePage.isLoadingIconDisappear(driver));

        // Verify Dashboard page display
        Assert.assertTrue(basePage.isElementDisplay(driver, "//h6[text()='Dashboard']"));

        // Click to PIM link
        basePage.clickToElement(driver, "//span[text()='PIM']/parent::a");
        Assert.assertTrue(basePage.isLoadingIconDisappear(driver));

        // Verify PIM page display
        Assert.assertTrue(basePage.isElementDisplay(driver, "//h6[text()='PIM']"));

        //Add Employee
        basePage.clickToElement(driver, "//a[text()='Add Employee']");
        Assert.assertTrue(basePage.isLoadingIconDisappear(driver));

        // Create new Employee
        basePage.sendkeyToElement(driver, "//input[@name='firstName']", firstName);
        basePage.sendkeyToElement(driver, "//input[@name='lastName']", lastName);


        employeeID = basePage.getElementDomProperty(driver, "//label[text()='Employee Id']//parent::div/following-sibling::div/input", "value");
        basePage.clickToElement(driver, "//p[text()='Create Login Details']/following-sibling::div//span");

        basePage.sleepInSecond(2);

        basePage.sendkeyToElement(driver, "//label[text()='Username']//parent::div/following-sibling::div/input", emailAddress);
        basePage.sendkeyToElement(driver, "//label[text()='Password']//parent::div/following-sibling::div/input", password);
        basePage.sendkeyToElement(driver, "//label[text()='Confirm Password']//parent::div/following-sibling::div/input", password);

        basePage.clickToElement(driver, "//button[contains(string(),'Save')]");

        //verify success msg displayed
        basePage.sleepInSecond(2);
        Assert.assertTrue(basePage.isElementDisplay(driver, "//p[text()='Successfully Saved']"));

        // loading icon at Add Employee page
        Assert.assertTrue(basePage.isLoadingIconDisappear(driver));

        // loading icon at detail page
        Assert.assertTrue(basePage.isLoadingIconDisappear(driver));

        // personal detail page
        Assert.assertEquals(basePage.getElementDomProperty(driver, "input[@name='firstName']","value"),firstName);
        Assert.assertEquals(basePage.getElementDomProperty(driver, "input[@name='lastName']","value"),lastName);
        Assert.assertEquals(basePage.getElementDomProperty(driver, "//label[text()='Employee Id']//parent::div/following-sibling::div/input", "value"), employeeID);

    }

}
