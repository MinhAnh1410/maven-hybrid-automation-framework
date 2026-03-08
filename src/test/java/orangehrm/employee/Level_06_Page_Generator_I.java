package orangehrm.employee;

import core.BasePage;
import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.orangehrm.*;
import pageObjects.orangehrm.myInfo.PersonalDetailPO;

public class Level_06_Page_Generator_I extends BaseTest {
    private WebDriver driver;
    private BasePage basePage = BasePage.getBasePage();
    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private EmployeeListPO employeeListPage;
    private PersonalDetailPO personalDetailPage;
    private AddEmployeePO addEmployeePage;
    private String adminUsername, adminPassword;
    private String firstName, lastName, fullName, emailAddress, password, employeeID, passportNumber, passportComment;


    @Parameters ({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        System.out.println("Run on browser: " + browserName);
        driver = getBrowserDriver(browserName, url);

        firstName = "Peter";
        lastName = "Crouch";
        adminUsername = "Admin";
        adminPassword = "admin123";
        fullName = firstName + " " + lastName;
        emailAddress = "peter" + getRandomNumber() + "@hotmail.com";
        password = "Testing111###";
        passportNumber = "43176122";
        passportComment = "Assigned Imigration\nRecords";

        // cách 1: (đang áp dụng) cứ chuyển trang theo business là khởi tạo trang mới
        // khởi tạo rõ trong class vi phạm Bad Practive trong lập trình: khởi tạo trực tiếp 1 page object trong test class
        loginPage = new LoginPO(driver);
    }

    @Test
    public void Employee_01_NewEmployee(){

        /* ============== Login Page ============= */
        loginPage.enterToUsernameTextbox(adminUsername);
        loginPage.enterToPasswordTextbox(adminPassword);
        loginPage.clickToLoginButton();

        /* ============== Dashboard Page ============= */
        dashboardPage = new DashboardPO(driver);

        Assert.assertTrue(dashboardPage.isLoadingIconDisappear(driver));
        Assert.assertTrue(dashboardPage.isDashboardHeaderDisplayed());
        dashboardPage.clickToPIMModule();

        /* ============== Employee Page ============= */
        employeeListPage = new EmployeeListPO(driver);

        Assert.assertTrue(employeeListPage.isLoadingIconDisappear(driver));
        Assert.assertTrue(employeeListPage.isPIMHeaderDisplayed());

        employeeListPage.clickToAddEmployeeButton();

        /* ============== Add Employee Page ============= */
        addEmployeePage = new AddEmployeePO(driver);

        Assert.assertTrue(addEmployeePage.isLoadingIconDisappear(driver));

        addEmployeePage.enterToFirstNameTextbox(firstName);
        addEmployeePage.enterToLastNameTextbox(lastName);

        employeeID = addEmployeePage.getEmployeeIDValue();

        addEmployeePage.clickToCreateLoginDetailCheckbox();
        addEmployeePage.sleepInSecond(2);

        addEmployeePage.enterToUsernameTextbox(emailAddress);
        addEmployeePage.enterToPasswordTextbox(password);
        addEmployeePage.enterToConfirmPasswordTextbox(password);

        addEmployeePage.clickToSaveButton();
        addEmployeePage.sleepInSecond(2);

        Assert.assertTrue(addEmployeePage.isSuccessfullySaveMessageDisplayed());

        /* ============== Personal Detail Page ============= */
        personalDetailPage = new PersonalDetailPO(driver);

        Assert.assertTrue(personalDetailPage.isLoadingIconDisappear(driver));
        Assert.assertTrue(personalDetailPage.isLoadingIconDisappear(driver));

        Assert.assertEquals(personalDetailPage.getFirstnameTextboxValue(), firstName);
        Assert.assertEquals(personalDetailPage.getLastnameTextboxValue(), lastName);
        Assert.assertEquals(personalDetailPage.getEmployeeTextboxValue(), employeeID);

        /* ============== Personal Detail Page - 02 ============= */
        personalDetailPage.clickToEmployeeListButton();
        employeeListPage = new EmployeeListPO(driver);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
