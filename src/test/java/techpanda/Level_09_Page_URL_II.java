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
import pageObjects.techpanda.admin.AdminOrderPO;
import pageObjects.techpanda.user.UserHomePO;
import pageObjects.techpanda.user.UserLoginPO;
import pageObjects.techpanda.user.UserMyAccountPO;

public class Level_09_Page_URL_II extends BaseTest {
    private WebDriver driver;
    private String adminUrl, userUrl;
    private String userWindowID, adminWindowID;

    @Parameters ({"Browser","UserUrl", "AdminUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl, String adminUrl) {
        driver = getBrowserDriver(browserName, userUrl);

        this.userUrl = userUrl;
        this.adminUrl = adminUrl;
        userHomePage = PageGeneration.getPage(UserHomePO.class, driver);
    }


    @Test
    public void Navigate_01_No_Logout(){
        userLoginPage = userHomePage.openMyAccountPage();
        userLoginPage.enterToEmailAddress("johnke32523n@gmail.net");
        userLoginPage.enterToPassword("123123");
        userMyAccountPage = userLoginPage.clickLoginButton();

        Assert.assertTrue(userMyAccountPage.isDashboardTitleDisplay());

        userWindowID =userMyAccountPage.getCurrentWindowID(driver);

        // mở 1 tab mới cho trang Admin
        userMyAccountPage.switchToNewTabByUrl(driver, adminUrl);
        adminLoginPage = PageGeneration.getPage(AdminLoginPO.class, driver);

        adminWindowID = adminLoginPage.getCurrentWindowID(driver);

        // thực hiện log in tại admin
        adminLoginPage.enterToUsername("user01");
        adminLoginPage.enterToPassword("guru99com");
        adminManageCustomerPage = adminLoginPage.clickLoginButton();
        adminManageCustomerPage.closeIncomingMessage();

        adminOrderPage = adminManageCustomerPage.openOrderPage(driver);

        // nhảy về tab chứa end user
        adminOrderPage.switchToWindowByID(driver, adminWindowID);

        // log out user
        userHomePage = userMyAccountPage.logoutToUserPage(driver);

        // nhảy qua tab chứa trang admin
        userHomePage.switchToWindowByID(driver, userWindowID);

        // log out admin
        userHomePage.logoutToAdminPage(driver);

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
    private AdminOrderPO adminOrderPage;
}
