package pageObjects.orangehrm.myInfo;

import core.BasePage;
import org.openqa.selenium.WebDriver;

public class ContactDetailPO extends MyInfoPO {
    private WebDriver driver;

    public ContactDetailPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
