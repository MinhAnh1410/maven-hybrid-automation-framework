package pageObjects.orangehrm;

import components.ButtonComponent;
import components.TextboxComponent;
import core.BaseComponent;
import org.openqa.selenium.WebDriver;
import pageUIs.orangehrm.AddEmployeeUI;

public class AddEmployeePO extends BaseComponent {
    private WebDriver driver;
    private TextboxComponent textboxComponent;
    private ButtonComponent buttonComponent;

    public AddEmployeePO(WebDriver driver) {
        super(driver);
        this.driver = driver;
        textboxComponent = new TextboxComponent(driver);
        buttonComponent = new ButtonComponent(driver);
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
        waitElementVisible(driver, AddEmployeeUI.USERNAME_TEXTBOX);
        sendkeyToElement(driver,AddEmployeeUI.USERNAME_TEXTBOX, emailAddress);
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

    public String getEmployeeID() {
        return textboxComponent.getTextboxValueByLabel("Employee Id");
    }


    public void createNewEmployee(String firstName, String lastName, String emailAddress, String password) {
        textboxComponent.enterToTextboxByName("firstName", firstName);
        textboxComponent.enterToTextboxByName("lastName", lastName);
        clickToCreateLoginDetailCheckbox();
        textboxComponent.enterToTextboxByLabel("Username", emailAddress);
        textboxComponent.enterToTextboxByLabel("Password", password);
        textboxComponent.enterToTextboxByLabel("Confirm Password", firstName);
        buttonComponent.clickToButtonByText("Save");
        sleepInSecond(2);
    }

    public boolean isPIMModuleTextDisplayed() {
        //waitElementVisible(driver, AddEmployeeUI.PIM_MODULE_TEXT);
        return isElementDisplay(driver, AddEmployeeUI.PIM_MODULE_TEXT);
    }

    public void clickToMainMenuSearchButton() {
        waitElementClickable(driver, AddEmployeeUI.MAIN_MENU_BUTTON);
        clickToElement(driver, AddEmployeeUI.MAIN_MENU_BUTTON);
        sleepInSecond(5);
    }

    public boolean isUsernameTextboxNonPresence() {
        // waitElementVisible(driver, AddEmployeeUI.USERNAME_TEXTBOX);
        return isElementNonPresence(driver, AddEmployeeUI.USERNAME_TEXTBOX);
    }

    public boolean isPasswordTextboxNonPresence() {
        return isElementNonePresence(driver, AddEmployeeUI.PASSWORD_TEXTBOX);
    }

    public boolean isConfirmPasswordTextboxNonPresence() {
        return isElementNotPresence(driver, AddEmployeeUI.CONFIRM_PASSWORD_TEXTBOX);
    }

    public boolean isUsernameTextboxDisplayed() {
        return isElementDisplay(driver, AddEmployeeUI.USERNAME_TEXTBOX);
    }

    public boolean isPIMModuleTextHidden() {
        return isElementHidden(driver, AddEmployeeUI.PIM_MODULE_TEXT);
    }
}
