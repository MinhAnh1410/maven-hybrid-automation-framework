package pageObjects.techpanda.admin;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.techpanda.admin.AdminManageCustomerPageUI;

public class AdminManageCustomerPO extends BasePage {
    private WebDriver driver;

    public AdminManageCustomerPO(WebDriver driver) {
        this.driver = driver;
    }

    public void closeIncomingMessage() {
        waitElementClickable(driver, AdminManageCustomerPageUI.INCOMING_MESSAGE_CLOSE_ICON);
        clickToElement(driver, AdminManageCustomerPageUI.INCOMING_MESSAGE_CLOSE_ICON);
    }
}
