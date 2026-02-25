package pageFactory.orangehrm;

import core.BasePage;
import core.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageUIs.orangehrm.AddEmployeeUI;

import java.util.List;

public class AddEmployeePO extends BasePageFactory {
    private WebDriver driver;

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstNameTextbox;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameTextbox;

    @FindBy(xpath = "//label[text()='Employee Id']//parent::div/following-sibling::div/input")
    private WebElement employeeIDTextbox;

    @FindBy(xpath = "//p[text()='Create Login Details']/following-sibling::div//span")
    private WebElement loginDetailCheckbox;

    @FindBy(xpath = "//label[text()='Username']//parent::div/following-sibling::div/input")
    private WebElement userTextbox;

    @FindBy(xpath = "//label[text()='Password']//parent::div/following-sibling::div/input")
    private WebElement passwordTextbox;

    @FindBy(xpath = "//label[text()='Confirm Password']//parent::div/following-sibling::div/input")
    private WebElement confirmPasswordTextbox;

    @FindBy(xpath = "//button[contains(string(),'Save')]")
    private WebElement saveButton;

    @FindBy(xpath = "//p[text()='Successfully Saved']")
    private WebElement saveMessage;

    public AddEmployeePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitElementVisible(driver, firstNameTextbox);
        sendkeyToElement(driver,firstNameTextbox, firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitElementVisible(driver, lastNameTextbox);
        sendkeyToElement(driver,lastNameTextbox, lastName);
    }

    public String getEmployeeIDValue() {
        waitElementVisible(driver, employeeIDTextbox);
        return getElementDomProperty(driver, employeeIDTextbox, "value");
    }

    public void clickToCreateLoginDetailCheckbox() {
        waitElementClickable(driver, loginDetailCheckbox);
        clickToElement(driver, loginDetailCheckbox);
    }

    public void enterToUsernameTextbox(String emailAddress) {
        waitElementVisible(driver, userTextbox);
        sendkeyToElement(driver,userTextbox, emailAddress);
    }

    public void enterToPasswordTextbox(String password) {
        waitElementVisible(driver, passwordTextbox);
        sendkeyToElement(driver,passwordTextbox, password);
    }

    public void enterToConfirmPasswordTextbox(String password) {
        waitElementVisible(driver, confirmPasswordTextbox);
        sendkeyToElement(driver,confirmPasswordTextbox, password);
    }

    public void clickToSaveButton() {
        waitElementClickable(driver, saveButton);
        clickToElement(driver, saveButton);
    }

    public boolean isSuccessfullySaveMessageDisplayed() {
        waitElementVisible(driver, saveMessage);
        return isElementDisplay(driver, saveMessage);
    }
}
