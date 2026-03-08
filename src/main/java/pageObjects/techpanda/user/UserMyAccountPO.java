package pageObjects.techpanda.user;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.techpanda.user.UserMyAccountPageUI;

public class UserMyAccountPO extends BasePage {
    private WebDriver driver;

    public UserMyAccountPO(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isDashboardTitleDisplay() {
        waitElementVisible(driver, UserMyAccountPageUI.DASHBOARD_HEADER_TEXT);
        return isElementDisplay(driver, UserMyAccountPageUI.DASHBOARD_HEADER_TEXT);
    }
}
