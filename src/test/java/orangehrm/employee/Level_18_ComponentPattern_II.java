package orangehrm.employee;

import core.BasePage;
import core.BaseTest;
import io.qameta.allure.*;
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

@Epic("")
@Feature("")
public class Level_18_ComponentPattern_II extends BaseTest {
    private WebDriver driver;
    private BasePage basePage = BasePage.getBasePage();
    private String adminUsername, adminPassword;
    private String firstName, lastName, fullName, emailAddress, password, employeeID, passportNumber, passportComment;
    private String browserName;

    @Parameters ({"Browser","Url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        System.out.println("Run on browser: " + browserName);
        driver = getBrowserDriver(browserName, url);

        this.browserName = browserName;

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

    @Description("Add new Employee")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void Employee_01_NewEmployee() {

        loginPage.loginToApplication(adminUsername,adminPassword);

        dashboardPage = PageGeneration.getPage(DashboardPO.class, driver);

        Assert.assertTrue(dashboardPage.isLoadingIconDisappear(driver));

        Assert.assertTrue(dashboardPage.isDashboardHeaderDisplayed());

        employeeListPage = dashboardPage.openPIMPage();

        Assert.assertTrue(employeeListPage.isLoadingIconDisappear(driver));

        Assert.assertTrue(employeeListPage.isPIMHeaderDisplayed());

    }

    @Description("View Employee")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void Employee_02_ViewEmployee() {

        addEmployeePage = employeeListPage.clickToAddEmployeeButton();

        Assert.assertTrue(addEmployeePage.isLoadingIconDisappear(driver));

        employeeID = addEmployeePage.getEmployeeID();

        addEmployeePage.createNewEmployee(firstName,lastName,emailAddress,password);

        Assert.assertTrue(addEmployeePage.isSuccessfullySaveMessageDisplayed());

        personalDetailPage = PageGenerator.getPersonalDetailPage(driver);

        Assert.assertTrue(personalDetailPage.isLoadingIconDisappear(driver));
        Assert.assertTrue(personalDetailPage.isLoadingIconDisappear(driver));

//        Assert.assertEquals(personalDetailPage.getTextboxValueByName("firstName"), firstName);
//        Assert.assertEquals(personalDetailPage.getTextboxValueByName("lastName"), lastName);
//        Assert.assertEquals(personalDetailPage.getTextboxValueByLabel("Employee Id"), employeeID);

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
