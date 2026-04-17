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

public class Level_13_Assert_Verify extends BaseTest {
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

        /* ============== Login Page ============= */
        loginPage.enterToUsernameTextbox(adminUsername);
        loginPage.enterToPasswordTextbox(adminPassword);

        /* ============== Dashboard Page ============= */
        dashboardPage = loginPage.clickToLoginButton();

        verifyTrue(dashboardPage.isLoadingIconDisappear(driver));
        verifyTrue(dashboardPage.isDashboardHeaderDisplayed());

        /* ============== Employee Page ============= */
        employeeListPage = dashboardPage.clickToPIMModule();

        verifyTrue(employeeListPage.isLoadingIconDisappear(driver));
        verifyTrue(employeeListPage.isPIMHeaderDisplayed());

        employeeListPage.clickToAddEmployeeButton();
    }

    @Test
    public void Employee_02_NewEmployee() {

        /* ============== Add Employee Page ============= */
        addEmployeePage = employeeListPage.clickToAddEmployeeButton();

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

        verifyFalse(addEmployeePage.isSuccessfullySaveMessageDisplayed());

        /* ============== Personal Detail Page ============= */
        personalDetailPage = PageGenerator.getPersonalDetailPage(driver);

        verifyTrue(personalDetailPage.isLoadingIconDisappear(driver));
        verifyTrue(personalDetailPage.isLoadingIconDisappear(driver));

        verifyEquals(personalDetailPage.getFirstnameTextboxValue(), firstName);
        verifyEquals(personalDetailPage.getLastnameTextboxValue(), lastName);
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
