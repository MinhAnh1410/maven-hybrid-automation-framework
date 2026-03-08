package orangehrm.employee;

import core.BasePage;
import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_03_Multiple_Browser extends BaseTest {
    private WebDriver driver;
    String firstName, lastName, fullName, emailAddress, password, employeeID, passportNumber, passportComment;

    @Parameters ({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        System.out.println("Run on browser: " + browserName);
        driver = getBrowserDriver(browserName);

        firstName = "Peter";
        lastName = "Crouch";
        fullName = firstName + " " + lastName;
        emailAddress = "peter" + new Random().nextInt(9999) + "@hotmail.com";
        password = "Testing111###";
        passportNumber = "43176122";
        passportComment = "Assigned Imigration\nRecords";
    }

    @Test
    public void Employee_01_NewEmployee(){

    }

}
