package pageObjects.orangehrm;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGeneration;
import pageObjects.PageGenerator;
import pageUIs.orangehrm.EmployeeListUI;

public class EmployeeListPO extends BasePage {
    private WebDriver driver;

    public EmployeeListPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPIMHeaderDisplayed() {
        waitElementVisible(driver, EmployeeListUI.PIM_HEADER);
        return isElementDisplay(driver, EmployeeListUI.PIM_HEADER);
    }

    public AddEmployeePO clickToAddEmployeeButton() {
        waitElementClickable(driver, EmployeeListUI.ADD_EMPLOYEE_BUTTON);
        clickToElement(driver, EmployeeListUI.ADD_EMPLOYEE_BUTTON);

        //  cách 2: (Page_Generator_II) khởi tạo ngay tại action cuối cùng của page cũ để chuyển sang page mới
        // return new AddEmployeePO(driver);

        //  cách 3: (Page_Generator_III) khởi tạo bằng hàm trong class chứa các hàm khởi tạo page
        // return PageGenerator.getAddEmployeePage(driver);

        // cách 4: Viết hàm java generic để truyền PO vào khởi tạo
        return PageGeneration.getPage(AddEmployeePO.class, driver);
    }
}
