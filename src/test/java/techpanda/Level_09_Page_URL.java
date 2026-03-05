package techpanda;

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGeneration;
import pageObjects.techpanda.admin.AdminLoginPO;
import pageObjects.techpanda.admin.AdminManageCustomerPO;
import pageObjects.techpanda.user.UserHomePO;
import pageObjects.techpanda.user.UserLoginPO;
import pageObjects.techpanda.user.UserMyAccountPO;

public class Level_09_Page_URL extends BaseTest {
    private WebDriver driver;
    private String adminUrl, userUrl;

    @Parameters ({"Browser","UserUrl", "AdminUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl, String adminUrl) {
        driver = getBrowserDriver(browserName, userUrl);

        this.adminUrl =userUrl;
        this.userUrl = adminUrl;
        userHomePage = PageGeneration.getPage(UserHomePO.class, driver);
    }

    @Test
    public void Navigate_01_No_Logout(){
        userLoginPage = userHomePage.openMyAccountPage();
        userLoginPage.enterToEmailAddress("johnke32523n@gmail.net");
        userLoginPage.enterToPassword("123123");
        userMyAccountPage = userLoginPage.clickLoginButton();

        Assert.assertTrue(userMyAccountPage.isDashboardTitleDisplay());



        // User -> Admin
        adminLoginPage = userMyAccountPage.openAdminPage(driver, adminUrl);

        adminLoginPage.enterToUsername("user01");
        adminLoginPage.enterToPassword("guru99com");
        adminManageCustomerPage = adminLoginPage.clickLoginButton();
        adminManageCustomerPage.closeIncomingMessage();

        // User -> Admin
        userHomePage = adminManageCustomerPage.openUserPage(driver, userUrl);

    }

    @Test
    public void Navigate_02_Logout(){

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private AdminLoginPO adminLoginPage;
    private AdminManageCustomerPO adminManageCustomerPage;
    private UserLoginPO userLoginPage;
    private UserHomePO userHomePage;
    private UserMyAccountPO userMyAccountPage;
}
