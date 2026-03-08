package pageObjects.techpanda.user;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGeneration;
import pageUIs.techpanda.user.UserLoginPageUI;

public class UserLoginPO extends BasePage {
    private WebDriver driver;

    public UserLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToEmailAddress(String emailAddress) {
        waitElementVisible(driver, UserLoginPageUI.EMAIL_ADDRESS_TEXTBOX);
        sendkeyToElement(driver, UserLoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
    }

    public void enterToPassword(String password) {
        waitElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public UserMyAccountPO clickLoginButton() {
        waitElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
        acceptToAlert(driver);
        return PageGeneration.getPage(UserMyAccountPO.class, driver);
    }
}
