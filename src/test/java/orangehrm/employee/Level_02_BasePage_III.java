package orangehrm.employee;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_02_BasePage_III extends BasePage{

    //Declare (Khai bao)
    private WebDriver driver;
    String firstName, lastName, fullName, emailAddress, password, employeeID, passportNumber, passportComment;

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();

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
    public void Employee_01_NewEmployee(){
        
        // sứ dụng class extend class nên ko cần khai báo và khởi tạo mà gọi trực tiếp hàm để sử dụng
        openPageUrl(driver, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Login
        sendkeyToElement(driver, "//input[@name='username']", "automationfc");
        sendkeyToElement(driver, "//input[@name='password']", "Auto222$$$");
        clickToElement(driver, "//button[contains(@class,'orangehrm-login-button')]");

        // Wait for all Loading icon disappear
        Assert.assertTrue(isLoadingIconDisappear(driver));

        // Verify Dashboard page display
        Assert.assertTrue(isElementDisplay(driver, "//h6[text()='Dashboard']"));

        // Click to PIM link
        clickToElement(driver, "//span[text()='PIM']/parent::a");
        Assert.assertTrue(isLoadingIconDisappear(driver));

        // Verify PIM page display
        Assert.assertTrue(isElementDisplay(driver, "//h6[text()='PIM']"));

        //Add Employee
        clickToElement(driver, "//a[text()='Add Employee']");
        Assert.assertTrue(isLoadingIconDisappear(driver));

        // Create new Employee
        sendkeyToElement(driver, "//input[@name='firstName']", firstName);
        sendkeyToElement(driver, "//input[@name='lastName']", lastName);


        employeeID = getElementDomProperty(driver, "//label[text()='Employee Id']//parent::div/following-sibling::div/input", "value");
        clickToElement(driver, "//p[text()='Create Login Details']/following-sibling::div//span");

        sleepInSecond(2);

        sendkeyToElement(driver, "//label[text()='Username']//parent::div/following-sibling::div/input", emailAddress);
        sendkeyToElement(driver, "//label[text()='Password']//parent::div/following-sibling::div/input", password);
        sendkeyToElement(driver, "//label[text()='Confirm Password']//parent::div/following-sibling::div/input", password);

        clickToElement(driver, "//button[contains(string(),'Save')]");

        //verify success msg displayed
        sleepInSecond(2);
        Assert.assertTrue(isElementDisplay(driver, "//p[text()='Successfully Saved']"));

        // loading icon at Add Employee page
        Assert.assertTrue(isLoadingIconDisappear(driver));

        // loading icon at detail page
        Assert.assertTrue(isLoadingIconDisappear(driver));

        // personal detail page
        Assert.assertEquals(getElementDomProperty(driver, "input[@name='firstName']","value"),firstName);
        Assert.assertEquals(getElementDomProperty(driver, "input[@name='lastName']","value"),lastName);
        Assert.assertEquals(getElementDomProperty(driver, "//label[text()='Employee Id']//parent::div/following-sibling::div/input", "value"), employeeID);

    }

}
