package orangehrm.employee;

import core.BasePage;
import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGeneration;
import pageObjects.PageGenerator;
import pageObjects.orangehrm.AddEmployeePO;
import pageObjects.orangehrm.DashboardPO;
import pageObjects.orangehrm.EmployeeListPO;
import pageObjects.orangehrm.LoginPO;
import pageObjects.orangehrm.myInfo.ContactDetailPO;
import pageObjects.orangehrm.myInfo.DependentPO;
import pageObjects.orangehrm.myInfo.JobPO;
import pageObjects.orangehrm.myInfo.PersonalDetailPO;

public class Level_14_Logging extends BaseTest {
    private WebDriver driver;
    private BasePage basePage = BasePage.getBasePage();
    private String adminUsername, adminPassword;
    private String firstName, lastName, fullName, emailAddress, password, employeeID, passportNumber, passportComment;


    @Parameters ({"Browser","Url"})
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

        loginPage = PageGeneration.getPage(LoginPO.class, driver);
    }

    @Test
    public void Employee_01_NewEmployee() {

        log.info("NewEmployee - Step 01: Enter to Username textbox with value is '"+ adminUsername + "'");
        loginPage.enterToUsernameTextbox(adminUsername);

        log.info("NewEmployee - Step 02: Enter to Password textbox with value is '"+ adminPassword + "'");
        loginPage.enterToPasswordTextbox(adminPassword);

        log.info("NewEmployee - Step 03: Click to Login button");
        dashboardPage = loginPage.clickToLoginButton();

        log.info("NewEmployee - Step 04: Verify loading icon invisible");
        verifyTrue(dashboardPage.isLoadingIconDisappear(driver));

        log.info("NewEmployee - Step 05: Verify Dashboard header is displayed");
        verifyFalse(dashboardPage.isDashboardHeaderDisplayed()); // lỗi

        log.info("NewEmployee - Step 06: Click to PIM menu link");
        employeeListPage = dashboardPage.clickToPIMModule();

        log.info("NewEmployee - Step 07: Verify loading icon invisible");
        verifyTrue(employeeListPage.isLoadingIconDisappear(driver));

        log.info("NewEmployee - Step 08: Verify PIM header is displayed");
        verifyFalse(employeeListPage.isPIMHeaderDisplayed()); // lỗi

    }

    @Test
    public void Employee_02_ViewEmployee() {

        log.info("ViewEmployee - Step 01: Click to Employee List menu link");
        addEmployeePage = employeeListPage.clickToAddEmployeeButton();

        log.info("ViewEmployee - Step 02: Verify loading icon invisible");
        Assert.assertTrue(addEmployeePage.isLoadingIconDisappear(driver));

        log.info("ViewEmployee - Step 03: Enter to First name textbox with value is '"+ firstName + "'");
        addEmployeePage.enterToFirstNameTextbox(firstName);

        log.info("ViewEmployee - Step 04: Enter to First name textbox with value is '"+ lastName + "'");
        addEmployeePage.enterToLastNameTextbox(lastName);

        log.info("ViewEmployee - Step 05: Get Employee ID value");
        employeeID = addEmployeePage.getEmployeeIDValue();

        log.info("ViewEmployee - Step 06: Click to Create Login Details checkbox");
        addEmployeePage.clickToCreateLoginDetailCheckbox();
        addEmployeePage.sleepInSecond(2);

        log.info("ViewEmployee - Step 07: Enter to Email textbox with value is '"+ emailAddress + "'");
        addEmployeePage.enterToUsernameTextbox(emailAddress);

        log.info("ViewEmployee - Step 08: Enter to Password textbox with value is '"+ password + "'");
        addEmployeePage.enterToPasswordTextbox(password);

        log.info("ViewEmployee - Step 09: Enter to Confirm Password textbox with value is '"+ password + "'");
        addEmployeePage.enterToConfirmPasswordTextbox(password);

        log.info("ViewEmployee - Step 10: Click to Save button");
        addEmployeePage.clickToSaveButton();
        addEmployeePage.sleepInSecond(2);

        log.info("ViewEmployee - Step 11: Verify Successfully Saved message is displayed");
        verifyFalse(addEmployeePage.isSuccessfullySaveMessageDisplayed()); // lỗi

        log.info("ViewEmployee - Step 12: Navigate to Personal Details page");
        personalDetailPage = PageGenerator.getPersonalDetailPage(driver);

        log.info("ViewEmployee - Step 13: Verify loading icon invisible");
        verifyTrue(personalDetailPage.isLoadingIconDisappear(driver));
        verifyTrue(personalDetailPage.isLoadingIconDisappear(driver));

        log.info("ViewEmployee - Step 14: Verify First name textbox value is '" + firstName + "'");
        verifyNotEquals(personalDetailPage.getFirstnameTextboxValue(), firstName); // lỗi

        log.info("ViewEmployee - Step 15: Verify Last name textbox value is '" + lastName + "'");
        verifyNotEquals(personalDetailPage.getLastnameTextboxValue(), lastName); // lỗi

        log.info("ViewEmployee - Step 16: Verify Employee ID textbox value is '" + employeeID + "'");
        verifyNotEquals(personalDetailPage.getEmployeeTextboxValue(), employeeID);
    }



    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private EmployeeListPO employeeListPage;
    private PersonalDetailPO personalDetailPage;
    private AddEmployeePO addEmployeePage;
    private ContactDetailPO contactDetailPage;
    private JobPO jobPage;
    private DependentPO dependentPage;

}
