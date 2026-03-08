package pageObjects.techpanda.admin;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGeneration;
import pageUIs.techpanda.admin.AdminLoginPageUI;

public class AdminLoginPO extends BasePage {
    private WebDriver driver;

    public AdminLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToUsername(String userName) {
        waitElementVisible(driver, AdminLoginPageUI.USERNAME_TEXTBOX);
        sendkeyToElement(driver, AdminLoginPageUI.USERNAME_TEXTBOX, userName);
    }

    public void enterToPassword(String password) {
        waitElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
    }


    public AdminManageCustomerPO clickLoginButton() {
        waitElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
        return PageGeneration.getPage(AdminManageCustomerPO.class, driver);
    }
}
