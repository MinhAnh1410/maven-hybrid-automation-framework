package pageObjects.orangehrm.myInfo;

import core.BasePage;
import org.openqa.selenium.WebDriver;

public class DependentPO extends MyInfoPO {
    private WebDriver driver;

    public DependentPO(WebDriver driver) {
        // gọi qua hàm khởi tạo lớp cha
        super(driver);

        // gọi đến biến thuộc phạm vi global trong lớp đó
        this.driver = driver;
    }
}
