package pageObjects.orangehrm;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGeneration;
import pageObjects.PageGenerator;
import pageUIs.orangehrm.DashboardUI;

public class DashboardPO extends BasePage {
    private WebDriver driver;

    public DashboardPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDashboardHeaderDisplayed() {
        // khi đang implement ở page object nào thì gọi qua page ui ở class đó
        waitElementVisible(driver, DashboardUI.DASHBOARD_HEADER);
        return isElementDisplay(driver, DashboardUI.DASHBOARD_HEADER);
    }

    public EmployeeListPO clickToPIMModule() {
        waitElementClickable(driver, DashboardUI.PIM_MODULE);
        clickToElement(driver, DashboardUI.PIM_MODULE);

        //  cách 2: (Page_Generator_II) khởi tạo ngay tại action cuối cùng của page cũ để chuyển sang page mới
        // return new EmployeeListPO(driver);

        //  cách 3: (Page_Generator_III) khởi tạo bằng hàm trong class chứa các hàm khởi tạo page
        // return PageGenerator.getEmployeeListPage(driver);

        // cách 4: Viết hàm java generic để truyền PO vào khởi tạo
        return PageGeneration.getPage(EmployeeListPO.class, driver);
    }
}
