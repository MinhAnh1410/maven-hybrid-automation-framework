package pageObjects.techpanda.user;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGeneration;
import pageUIs.techpanda.user.UserHomePageUI;

public class UserHomePO extends BasePage {
    private WebDriver driver;

    public UserHomePO(WebDriver driver) {
        this.driver = driver;
    }

    public UserLoginPO openMyAccountPage() {
        waitElementClickable(driver, UserHomePageUI.MY_ACCOUNT_FOOTER);
        clickToElement(driver,UserHomePageUI.MY_ACCOUNT_FOOTER);
        return PageGeneration.getPage(UserLoginPO.class,driver);
    }
}
