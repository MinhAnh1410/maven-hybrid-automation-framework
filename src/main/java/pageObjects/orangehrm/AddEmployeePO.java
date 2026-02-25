package pageObjects.orangehrm;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.orangehrm.AddEmployeeUI;

public class AddEmployeePO extends BasePage {
    private WebDriver driver;

    public AddEmployeePO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitElementVisible(driver, AddEmployeeUI.FIRSTNAME_TEXTBOX);
        sendkeyToElement(driver,AddEmployeeUI.FIRSTNAME_TEXTBOX, firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitElementVisible(driver, AddEmployeeUI.LASTNAME_TEXTBOX);
        sendkeyToElement(driver,AddEmployeeUI.LASTNAME_TEXTBOX, lastName);
    }

    public String getEmployeeIDValue() {
        waitElementPresence(driver, AddEmployeeUI.EMPLOYEE_ID_TEXTBOX);
        return getElementDomProperty(driver, AddEmployeeUI.EMPLOYEE_ID_TEXTBOX, "value");
    }

    public void clickToCreateLoginDetailCheckbox() {
        waitElementClickable(driver, AddEmployeeUI.CREATE_LOGIN_DETAIL_CHECKBOX);
        clickToElement(driver, AddEmployeeUI.CREATE_LOGIN_DETAIL_CHECKBOX);
    }

    public void enterToUsernameTextbox(String emailAddress) {
        waitElementVisible(driver, AddEmployeeUI.USER_TEXTBOX);
        sendkeyToElement(driver,AddEmployeeUI.USER_TEXTBOX, emailAddress);
    }

    public void enterToPasswordTextbox(String password) {
        waitElementVisible(driver, AddEmployeeUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver,AddEmployeeUI.PASSWORD_TEXTBOX, password);
    }

    public void enterToConfirmPasswordTextbox(String password) {
        waitElementVisible(driver, AddEmployeeUI.CONFIRM_PASSWORD_TEXTBOX);
        sendkeyToElement(driver,AddEmployeeUI.CONFIRM_PASSWORD_TEXTBOX, password);
    }

    public void clickToSaveButton() {
        waitElementClickable(driver, AddEmployeeUI.SAVE_BUTTON);
        clickToElement(driver, AddEmployeeUI.SAVE_BUTTON);
    }

    public boolean isSuccessfullySaveMessageDisplayed() {
        waitListElementVisible(driver, AddEmployeeUI.SUCCESSFULL_SAVE_MESSAGE);
        return isElementDisplay(driver, AddEmployeeUI.SUCCESSFULL_SAVE_MESSAGE);
    }
}
