package pageObjects.orangehrm.myInfo;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGeneration;
import pageObjects.orangehrm.EmployeeListPO;
import pageUIs.orangehrm.myInfo.PersonalDetailUI;

public class PersonalDetailPO extends MyInfoPO {
    private WebDriver driver;

    public PersonalDetailPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getFirstnameTextboxValue() {
        waitElementPresence( driver, PersonalDetailUI.FIRSTNAME_TEXTBOX);
        return getElementDomProperty( driver, PersonalDetailUI.FIRSTNAME_TEXTBOX,"value");
    }

    public String getLastnameTextboxValue() {
        waitElementPresence( driver, PersonalDetailUI.LASTNAME_TEXTBOX);
        return getElementDomProperty( driver, PersonalDetailUI.LASTNAME_TEXTBOX,"value");
    }

    public String getEmployeeTextboxValue() {
        waitElementPresence( driver, PersonalDetailUI.EMPLOYEE_ID_TEXTBOX);
        return getElementDomProperty( driver, PersonalDetailUI.EMPLOYEE_ID_TEXTBOX,"value");
    }

    public EmployeeListPO clickToEmployeeListButton() {
        waitElementClickable( driver, PersonalDetailUI.EMPLOYEE_LIST_BUTTON);
        clickToElement(driver, PersonalDetailUI.EMPLOYEE_LIST_BUTTON);

        //  cách 2: (Page_Generator_II) khởi tạo ngay tại action cuối cùng của page cũ để chuyển sang page mới
        // return new EmployeeListPO(driver);

        //  cách 3: (Page_Generator_III) khởi tạo bằng hàm trong class chứa các hàm khởi tạo page
        // return PageGenerator.getEmployeeListPage(driver);

        // cách 4: Viết hàm java generic để truyền PO vào khởi tạo
        return PageGeneration.getPage(EmployeeListPO.class, driver);
    }

}
