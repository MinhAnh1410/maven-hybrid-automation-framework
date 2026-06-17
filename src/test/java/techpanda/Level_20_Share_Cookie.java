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
import techpanda.cookie.Register;

public class Level_20_Share_Cookie extends BaseTest {
    private WebDriver driver;
    private String adminUrl, userUrl;

    @Parameters ({"Browser","UserUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String userUrl) {
        driver = getBrowserDriver(browserName, userUrl);

        userHomePage = PageGeneration.getPage(UserHomePO.class, driver);
    }


    @Test
    public void Register(){
        userLoginPage = userHomePage.openMyAccountPage();
        userLoginPage.setCookies(driver, Register.cookieSet);
        userLoginPage.refreshCurrentPage(driver);

        userMyAccountPage = PageGeneration.getPage(UserMyAccountPO.class, driver);

        Assert.assertTrue(userMyAccountPage.isDashboardTitleDisplay());
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
