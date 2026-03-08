package orangehrm.employee;

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

public class Level_01_DontRepeatYourself {
    WebDriver driver;
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
    public void Employee_01_NewEmployee() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // đăng nhập
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();

        //wait cho tất cả các icon loading biến mất
        Assert.assertTrue(isLoadingIconDisappear());


        //Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"); Không verify bằng URL

        //Kiểm tra trang PIM đã được direct thành công (kểm tra bằng cách header PIM đã hiển thị hay chưa)
        Assert.assertTrue(driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed());

        //mở trang PIM
        driver.findElement(By.xpath("//span[text()='PIM']/parent::a")).click();
        Assert.assertTrue(isLoadingIconDisappear());

        //Kiểm tra trang PIM đã được direct thành công (kểm tra bằng cách header PIM đã hiển thị hay chưa)
        Assert.assertTrue(driver.findElement(By.xpath("//h6[text()='PIM']")).isDisplayed());

        //mở trang Add Employee
        driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
        Assert.assertTrue(isLoadingIconDisappear());

        //create new Employee
        driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys(lastName);
        employeeID =  driver.findElement(By.xpath("//label[text()='Employee Id']//parent::div/following-sibling::div/input")).getDomProperty("value");
        System.out.println(employeeID);


        driver.findElement(By.xpath("//p[text()='Create Login Details']/following-sibling::div//span")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//label[text()='Username']//parent::div/following-sibling::div/input")).sendKeys(emailAddress);
        driver.findElement(By.xpath("//label[text()='Password']//parent::div/following-sibling::div/input")).sendKeys(password);
        driver.findElement(By.xpath("//label[text()='Confirm Password']//parent::div/following-sibling::div/input")).sendKeys(password);

        driver.findElement(By.xpath("//button[contains(string(),'Save')]")).click();

        //verify success msg displayed
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Successfully Saved']")).isDisplayed());

        // loading icon at Add Employee page
        Assert.assertTrue(isLoadingIconDisappear());

        // loading icon at detail page
        Assert.assertTrue(isLoadingIconDisappear());

        // personal detail page
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='firstName']")).getDomProperty("value"), firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='lastName']")).getDomProperty("value"), lastName);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']//parent::div/following-sibling::div/input")).getDomProperty("value"), employeeID);

        // immigration page
        driver.findElement(By.xpath("//a[text()='Immigration']")).click();
        Assert.assertTrue(isLoadingIconDisappear());

        driver.findElement(By.xpath("//h6[text()='Assigned Immigration Records']/following-sibling::button[contains(string(),'Add')]")).click();

        driver.findElement(By.xpath("//label[text()='Number']//parent::div/following-sibling::div/input")).sendKeys(passportNumber);
        driver.findElement(By.xpath("//label[text()='Comments']//parent::div/following-sibling::div/textarea")).sendKeys(passportComment);

        driver.findElement(By.xpath("//button[contains(string(),'Save')]")).click();

        Thread.sleep(2000);

        //verify success msg displayed
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Successfully Saved']")).isDisplayed());
        Assert.assertTrue(isLoadingIconDisappear());


        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Passport']/parent::div/following-sibling::div/div[text()='" + passportNumber + "']")).isDisplayed());

        //logout
        driver.findElement(By.cssSelector("li.oxd-userdropdown")).click();
        driver.findElement(By.xpath("//a[text()='Logout']")).click();

        //login
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(emailAddress);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();

        //wait cho tất cả các icon loading biến mất
        Assert.assertTrue(isLoadingIconDisappear());

        Assert.assertTrue(driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed());

        // click My info page
        driver.findElement(By.xpath("//span[text()='My Info']/parent::a")).click();
        Assert.assertTrue(isLoadingIconDisappear());

        // personal detail page
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='firstName")).getDomProperty("value"), firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='lastName")).getDomProperty("value"), lastName);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']//parent::div/following-sibling::div/input")).getDomProperty("value"), employeeID);

        Assert.assertTrue(driver.findElement(By.cssSelector("input[name='lastName")).isEnabled());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[name='firstName")).isEnabled());
        Assert.assertFalse(driver.findElement(By.xpath("//label[text()='Employee Id']//parent::div/following-sibling::div/input")).isEnabled());

        // immigration page
        driver.findElement(By.xpath("//a[text()='Immigration']")).click();
        Assert.assertTrue(isLoadingIconDisappear());

        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Passport']/parent::div/following-sibling::div/div[text()='" + passportNumber + "']")).isDisplayed());
    }

    private Boolean isLoadingIconDisappear() {
        return new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.
                invisibilityOfAllElements(driver.findElements(By.cssSelector("div.oxd-loading-spinner"))));
    }
}
