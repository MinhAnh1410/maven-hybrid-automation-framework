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
import pageObjects.orangehrm.AddEmployeePO;
import pageObjects.orangehrm.DashboardPO;
import pageObjects.orangehrm.EmployeeListPO;
import pageObjects.orangehrm.LoginPO;
import pageObjects.orangehrm.myInfo.ContactDetailPO;
import pageObjects.orangehrm.myInfo.DependentPO;
import pageObjects.orangehrm.myInfo.JobPO;
import pageObjects.orangehrm.myInfo.PersonalDetailPO;

public class Level_19_Undisplayed extends BaseTest {
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

        /* ============== Add Employee Page ============= */
        addEmployeePage = employeeListPage.clickToAddEmployeeButton();

        Assert.assertTrue(addEmployeePage.isLoadingIconDisappear(driver));

        addEmployeePage.enterToFirstNameTextbox(firstName);
        addEmployeePage.enterToLastNameTextbox(lastName);

        employeeID = addEmployeePage.getEmployeeIDValue();

        addEmployeePage.clickToCreateLoginDetailCheckbox();
        addEmployeePage.sleepInSecond(2);

        // Verify Username textbox is displayed
        // TH1: Element có hiển thị ở UI và có xuất hiện trong DOM (Visible/ Displayed)
        verifyTrue(addEmployeePage.isUsernameTextboxDisplayed());

        // TH2: Element không hiển thị trên UI và có trong DOM (Invisible)
        verifyTrue(addEmployeePage.isPIMModuleTextDisplayed());

        addEmployeePage.clickToMainMenuSearchButton();

        // TH2: Element không hiển thị trên UI và có trong DOM (Invisible)
        //verifyFalse(addEmployeePage.isPIMModuleTextDisplayed());
        verifyTrue(addEmployeePage.isPIMModuleTextHidden());

        addEmployeePage.enterToUsernameTextbox(emailAddress);
        addEmployeePage.enterToPasswordTextbox(password);
        addEmployeePage.enterToConfirmPasswordTextbox(password);

        addEmployeePage.sleepInSecond(2);
        addEmployeePage.clickToCreateLoginDetailCheckbox();

        // Verify Username textbox is undisplayed
        // TH3: Element không hiển thị trên UI và không có trong DOM (Invisible)
        verifyTrue(addEmployeePage.isUsernameTextboxNonPresence());
        verifyTrue(addEmployeePage.isPasswordTextboxNonPresence());
        verifyTrue(addEmployeePage.isConfirmPasswordTextboxNonPresence());

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
