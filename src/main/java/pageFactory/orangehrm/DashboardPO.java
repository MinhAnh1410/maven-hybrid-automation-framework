package pageFactory.orangehrm;

import core.BasePage;
import core.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageUIs.orangehrm.DashboardUI;

public class DashboardPO extends BasePageFactory {
    private WebDriver driver;

    @FindBy(xpath = "//h6[text()='Dashboard']")
    private WebElement dashboardHeader;

    @FindBy(xpath = "//span[text()='PIM']/parent::a")
    private WebElement PIMModule;

    public DashboardPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isDashboardHeaderDisplayed() {
        waitElementVisible(driver, dashboardHeader);
        return isElementDisplay(driver, dashboardHeader);
    }

    public void clickToPIMModule() {
        waitElementClickable(driver, PIMModule);
        clickToElement(driver, PIMModule);
    }
}
