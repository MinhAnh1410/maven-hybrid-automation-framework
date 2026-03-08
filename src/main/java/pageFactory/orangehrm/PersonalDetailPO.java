package pageFactory.orangehrm;

import core.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDetailPO extends BasePageFactory {
    private WebDriver driver;

    @FindBy(xpath = "input[@name='firstName']")
    private WebElement firstNameTextbox;

    @FindBy(xpath = "input[@name='lastName']")
    private WebElement lastNameTextbox;

    @FindBy(xpath = "//label[text()='Employee Id']//parent::div/following-sibling::div/input")
    private WebElement employeeIDTextbox;

    public PersonalDetailPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getFirstnameTextboxValue() {
        waitElementVisible( driver, firstNameTextbox);
        return getElementDomProperty( driver, firstNameTextbox,"value");
    }

    public String getLastnameTextboxValue() {
        waitElementVisible( driver, lastNameTextbox);
        return getElementDomProperty( driver, lastNameTextbox,"value");
    }

    public String getEmployeeTextboxValue() {
        waitElementVisible( driver, employeeIDTextbox);
        return getElementDomProperty( driver, employeeIDTextbox,"value");
    }
}
