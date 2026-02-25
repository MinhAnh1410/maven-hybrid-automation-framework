package pageFactory.orangehrm;

import core.BasePage;
import core.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pageUIs.orangehrm.EmployeeListUI;

public class EmployeeListPO extends BasePageFactory {
    private WebDriver driver;

    @FindBy(xpath = "//h6[text()='PIM']")
    private WebElement PIMHeader;

    @FindBy(xpath = "//a[text()='Add Employee']")
    private WebElement addEmployeeButton;

    public EmployeeListPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPIMHeaderDisplayed() {
        waitElementVisible(driver, PIMHeader);
        return isElementDisplay(driver, PIMHeader);
    }

    public void clickToAddEmployeeButton() {
        waitElementClickable(driver, addEmployeeButton);
        clickToElement(driver, addEmployeeButton);
    }
}
