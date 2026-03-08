package pageObjects.orangehrm.myInfo;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGeneration;
import pageUIs.orangehrm.myInfo.MyInfoPageUI;

public class MyInfoPO extends BasePage {
    private WebDriver driver;

    public MyInfoPO(WebDriver driver) {
        this.driver = driver;
    }

    public ContactDetailPO openContactDetailPage(WebDriver driver) {
        waitElementClickable( driver, MyInfoPageUI.CONTACT_DETAIL_LINK);
        clickToElement(driver, MyInfoPageUI.CONTACT_DETAIL_LINK);
        return PageGeneration.getPage(ContactDetailPO.class, driver);
    }

    public JobPO openJobPage(WebDriver driver) {
        waitElementClickable( driver, MyInfoPageUI.JOB_LINK);
        clickToElement(driver, MyInfoPageUI.JOB_LINK);
        return PageGeneration.getPage(JobPO.class, driver);
    }

    public DependentPO openDependentPage(WebDriver driver) {
        waitElementClickable( driver, MyInfoPageUI.DEPENDENT_LINK);
        clickToElement(driver, MyInfoPageUI.DEPENDENT_LINK);
        return PageGeneration.getPage(DependentPO.class, driver);
    }

    public PersonalDetailPO openPersonalDetailPage(WebDriver driver) {
        waitElementClickable( driver, MyInfoPageUI.PERSONAL_DETAIL_LINK);
        clickToElement(driver, MyInfoPageUI.PERSONAL_DETAIL_LINK);
        return PageGeneration.getPage(PersonalDetailPO.class, driver);
    }

}
