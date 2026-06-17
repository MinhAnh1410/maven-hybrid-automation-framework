package pageObjects.techpanda.user;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGeneration;
import pageUIs.techpanda.user.UserLoginPageUI;
import pageUIs.techpanda.user.UserMyAccountPageUI;
import pageUIs.techpanda.user.UserRegisterPageUI;

public class UserRegisterPO extends BasePage {
    private WebDriver driver;

    public UserRegisterPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToFirstName(String firstName) {
        waitElementVisible(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
    }

    public void enterToLastName(String lastName) {
        waitElementVisible(driver, UserRegisterPageUI.LASTNAME_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.LASTNAME_TEXTBOX, lastName);
    }

    public void enterToEmailAddress(String emailAddress) {
        waitElementVisible(driver, UserRegisterPageUI.EMAIL_ADDRESS_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
    }

    public void enterToPassword(String password) {
        waitElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    public void enterToConfirmPassword(String password) {
        waitElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
    }

    public UserMyAccountPO clickRegisterButton() {
        waitElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
//        if (driver.toString().contains("Chrome")) {
//            waitElementClickable(driver, UserRegisterPageUI.SEND_ANYWAY_BUTTON);
//            clickToElement(driver, UserRegisterPageUI.SEND_ANYWAY_BUTTON);
//        } else {
//            acceptToAlert(driver);
//        }
        return PageGeneration.getPage(UserMyAccountPO.class, driver);
    }
}
