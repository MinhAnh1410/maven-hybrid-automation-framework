package pageObjects;

import org.openqa.selenium.WebDriver;
import pageObjects.orangehrm.*;
import pageObjects.orangehrm.myInfo.PersonalDetailPO;

public class PageGenerator {

    public static LoginPO getLoginPage(WebDriver driver){
        return new LoginPO(driver);
    }

    public static DashboardPO getDashboardPage(WebDriver driver){
        return new DashboardPO(driver);
    }

    public static EmployeeListPO getEmployeeListPage(WebDriver driver){
        return new EmployeeListPO(driver);
    }

    public static AddEmployeePO getAddEmployeePage(WebDriver driver){
        return new AddEmployeePO(driver);
    }

    public static PersonalDetailPO getPersonalDetailPage(WebDriver driver){
        return new PersonalDetailPO(driver);
    }
}
