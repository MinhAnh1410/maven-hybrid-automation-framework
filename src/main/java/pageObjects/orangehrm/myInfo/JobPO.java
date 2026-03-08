package pageObjects.orangehrm.myInfo;

import core.BasePage;
import org.openqa.selenium.WebDriver;

public class JobPO extends MyInfoPO {

    private WebDriver driver;

    public JobPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
