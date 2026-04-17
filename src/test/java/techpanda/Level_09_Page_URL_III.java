package techpanda;

import core.BaseTest;
import core.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGeneration;
import pageObjects.techpanda.admin.AdminLoginPO;
import pageObjects.techpanda.admin.AdminManageCustomerPO;
import pageObjects.techpanda.admin.AdminOrderPO;
import pageObjects.techpanda.user.UserHomePO;
import pageObjects.techpanda.user.UserLoginPO;
import pageObjects.techpanda.user.UserMyAccountPO;

public class Level_09_Page_URL_III extends BaseTest {
    private WebDriver userDriver, adminDriver;

    @Parameters ({"Browser","UserUrl", "AdminUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl, String adminUrl) {

        // Session 1 - User
        userDriver = getBrowserDriver(browserName, userUrl);
        userHomePage = PageGeneration.getPage(UserHomePO.class, userDriver);

        // Session 2 - Admin
        adminDriver = getBrowserDriver(browserName, adminUrl);
        adminLoginPage = PageGeneration.getPage(AdminLoginPO.class, adminDriver);
    }


    @Test
    public void Navigate_01_No_Logout(){

        // Session 1 - User
        userLoginPage = userHomePage.openMyAccountPage();
        userLoginPage.enterToEmailAddress("johnke32523n@gmail.net");
        userLoginPage.enterToPassword("123123");
        userMyAccountPage = userLoginPage.clickLoginButton();

        Assert.assertTrue(userMyAccountPage.isDashboardTitleDisplay());

        // Session 2 - Admin
        adminLoginPage.enterToUsername(GlobalConstants.ADMIN_USERNAME);
        adminLoginPage.enterToPassword(GlobalConstants.ADMIN_PASSWORD);
        adminManageCustomerPage = adminLoginPage.clickLoginButton();
        adminManageCustomerPage.closeIncomingMessage();

        adminOrderPage = adminManageCustomerPage.openOrderPage(adminDriver);

        // Session 1 - User
        // log out user
        userHomePage = userMyAccountPage.logoutToUserPage(userDriver);
        userLoginPage = userHomePage.openMyAccountPage();
        userLoginPage.enterToEmailAddress("johnke32523n@gmail.net");
        userLoginPage.enterToPassword("123123");
        userMyAccountPage = userLoginPage.clickLoginButton();

        // Session 2 - Admin
        // log out admin
        userHomePage.logoutToAdminPage(adminDriver);
        adminLoginPage.enterToUsername(GlobalConstants.ADMIN_USERNAME);
        adminLoginPage.enterToPassword(GlobalConstants.ADMIN_PASSWORD);
        adminManageCustomerPage = adminLoginPage.clickLoginButton();
        adminManageCustomerPage.closeIncomingMessage();

        adminOrderPage = adminManageCustomerPage.openOrderPage(adminDriver);

    }

    @AfterClass
    public void afterClass() {
        userDriver.quit();
        adminDriver.quit();
    }

    private AdminLoginPO adminLoginPage;
    private AdminManageCustomerPO adminManageCustomerPage;
    private UserLoginPO userLoginPage;
    private UserHomePO userHomePage;
    private UserMyAccountPO userMyAccountPage;
    private AdminOrderPO adminOrderPage;
}
