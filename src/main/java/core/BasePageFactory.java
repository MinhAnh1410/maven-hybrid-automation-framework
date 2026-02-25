package core;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePageFactory {

    // Nguyên tắc
    // 1- phạm vi truy cập: public/ protected/ private/ default
    // 2- kiểu dl hàm: void/int/ boolean/ string/ list element/..
    // 3- tên hàm có ý nghĩa + lowerCase
    // 4- tham số (nếu có)
    // 5- kiểu dl trả về

    public static BasePageFactory getBasePage() {
        return new BasePageFactory();
    }

    public void clickToElement(WebDriver driver, WebElement element) {
        element.click();
    }

    public boolean isElementDisplay (WebDriver driver, WebElement element) {
        return element.isDisplayed();
    }

    public void sendkeyToElement (WebDriver driver, WebElement element, String valueToSend) {
        element.sendKeys(valueToSend);
    }

    public String getElementText (WebDriver driver, WebElement element){
        return element.getText();
    }

    public String getElementDomProperty (WebDriver driver, WebElement element, String propertyName){
        return element.getDomAttribute(propertyName);
    }

    public WebElement waitElementVisible(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitListElementVisible(WebDriver driver, List<WebElement> elements) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.visibilityOf(elements));
    }

    public boolean waitElementInvisible(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.invisibilityOf(element));
    }

    public boolean waitListElementInvisible(WebDriver driver, List<WebElement> elements) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.invisibilityOfAllElements(elements));
    }

    public WebElement waitElementClickable(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

//    public boolean isLoadingIconDisappear(WebDriver driver) {
//        return waitListElementInvisible(driver,"//div[contains(@class,'oxd-loading-spinner')]");
//    }

    private Duration shortTimeout = Duration.ofSeconds(10);
    private Duration longTimeout = Duration.ofSeconds(30);

}
