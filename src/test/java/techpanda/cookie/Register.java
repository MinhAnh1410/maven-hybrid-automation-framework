package techpanda.cookie;

import core.BaseTest;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.PageGeneration;
import pageObjects.techpanda.admin.AdminLoginPO;
import pageObjects.techpanda.admin.AdminManageCustomerPO;
import pageObjects.techpanda.user.UserHomePO;
import pageObjects.techpanda.user.UserLoginPO;
import pageObjects.techpanda.user.UserMyAccountPO;
import pageObjects.techpanda.user.UserRegisterPO;

import java.util.Set;

public class Register extends BaseTest {
    private WebDriver driver;
    private String firstName, lastName, emailAddress, password;
    public static Set<Cookie> cookieSet;

    @Parameters ({"Browser","UserUrl"})
    @BeforeTest
    public void beforeClass(String browserName, String userUrl) {
        driver = getBrowserDriver(browserName, userUrl);

        firstName = "Automation";
        lastName = "FC";
        emailAddress = "afc" + getRandomNumber() + "@gmail.vn";
        password = "123456";

        userHomePage = PageGeneration.getPage(UserHomePO.class, driver);

        userLoginPage = userHomePage.openMyAccountPage();

        userRegisterPage = userLoginPage.openRegisterPage();

        userRegisterPage.enterToFirstName(firstName);
        userRegisterPage.enterToLastName(lastName);
        userRegisterPage.enterToEmailAddress(emailAddress);
        userRegisterPage.enterToPassword(password);
        userRegisterPage.enterToConfirmPassword(password);
        userMyAccountPage = userRegisterPage.clickRegisterButton();

        Assert.assertTrue(userMyAccountPage.isDashboardTitleDisplay());

        //Get cookie
        cookieSet = userMyAccountPage.getCookies(driver);

    }


    @AfterTest
    public void afterClass() {
        driver.quit();
    }

    private AdminLoginPO adminLoginPage;
    private AdminManageCustomerPO adminManageCustomerPage;
    private UserLoginPO userLoginPage;
    private UserHomePO userHomePage;
    private UserMyAccountPO userMyAccountPage;
    private UserRegisterPO userRegisterPage;
}
