package pageObjects.jquery;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.jquery.UploadPageUI;

import java.util.List;

public class UploadPO extends BasePage {
    private WebDriver driver;

    public UploadPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isFileLoadedSuccess(String fileName) {
        waitElementVisible(driver, UploadPageUI.FILE_NAME_LOADED, fileName);
        return isElementDisplay(driver, UploadPageUI.FILE_NAME_LOADED, fileName);
    }

    public void clickStartButton() {
//        waitElementClickable(driver, UploadPageUI.START_UPLOAD_BUTTON);
//        clickToElement(driver, UploadPageUI.START_UPLOAD_BUTTON);

        List<WebElement> startButtons = getListElement(driver, UploadPageUI.START_BUTTON);

        for (WebElement start : startButtons){
            start.click();
            sleepInSecond(1);
        }
    }

    public boolean isFileUploadSuccess(String fileName) {
        waitElementVisible(driver, UploadPageUI.FILE_NAME_UPLOADED, fileName);
        return isElementDisplay(driver, UploadPageUI.FILE_NAME_UPLOADED, fileName);
    }

    public boolean isFileTypeNotAllowed(String fileName) {
        waitElementVisible(driver, UploadPageUI.FILE_TYPE_NOT_ALLOWED_MSG, fileName);
        return isElementDisplay(driver, UploadPageUI.FILE_TYPE_NOT_ALLOWED_MSG, fileName);
    }
}
