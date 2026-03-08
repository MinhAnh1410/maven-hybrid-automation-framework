package core;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.PageGeneration;
import pageObjects.orangehrm.myInfo.ContactDetailPO;
import pageObjects.orangehrm.myInfo.DependentPO;
import pageObjects.orangehrm.myInfo.JobPO;
import pageObjects.orangehrm.myInfo.PersonalDetailPO;
import pageObjects.techpanda.admin.AdminLoginPO;
import pageObjects.techpanda.user.UserHomePO;
import pageUIs.orangehrm.BasePageUI;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {

    // Nguyên tắc
    // 1- phạm vi truy cập: public/ protected/ private/ default
    // 2- kiểu dl hàm: void/int/ boolean/ string/ list element/..
    // 3- tên hàm có ý nghĩa + lowerCase
    // 4- tham số (nếu có)
    // 5- kiểu dl trả về

    public static BasePage getBasePage() {
        return new BasePage();
    }

    // hàm tương tác với web browser
    public void openPageUrl (WebDriver driver, String url) {
        driver.get(url);
    }

    public String getPageTitle (WebDriver driver) {
        return driver.getTitle();
    }

    public String getPageUrl (WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSource (WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPage (WebDriver driver) {
        driver.navigate().back();
    }

    public void fowardToPage (WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshCurrentPage (WebDriver driver) {
        driver.navigate().refresh();
    }

    private Alert waitAlertPresence (WebDriver driver) {
        return new WebDriverWait(driver, shortTimeout).until(ExpectedConditions.alertIsPresent());

    }

    public void acceptToAlert (WebDriver driver) {
        waitAlertPresence(driver).accept();
    }

    public void cancelToAlert (WebDriver driver) {
        waitAlertPresence(driver).dismiss();
    }

    public void sendkeyToAlert (WebDriver driver, String keyToSend) {
        waitAlertPresence(driver).sendKeys(keyToSend);
    }

    public String getAlertText (WebDriver driver) {
        return waitAlertPresence(driver).getText();
    }

    public void sleepInSecond (long timeInSecond) {
        try {
            Thread.sleep(timeInSecond *1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void switchToWindowByID(WebDriver driver, String WindowID) {
        Set<String> allWindowIDs = driver.getWindowHandles();
        for (String id : allWindowIDs) {
            if (!id.equals(WindowID)) {
                driver.switchTo().window(id);
            }
        }
    }

    public void switchToWindowByPageTitle(WebDriver driver, String expectedPageTitle) throws InterruptedException {
        Set<String> allWindowsIDs = driver.getWindowHandles();

        for (String id : allWindowsIDs) {
            driver.switchTo().window(id);
            sleepInSecond(2);
            String pageTitle = driver.getTitle();
            if (pageTitle.equals(expectedPageTitle)){
                break;
            }
        }
    }

    public void closeAllWindowsWithoutParent(WebDriver driver, String GithubWindowID) throws InterruptedException {
        Set<String> allWindowsIDs = driver.getWindowHandles();

        for (String id : allWindowsIDs) {
            if (!id.equals(GithubWindowID)) {
                driver.switchTo().window(id);
                sleepInSecond(2);
                driver.close();
            }
        }
        driver.switchTo().window(GithubWindowID);
    }

    private static By getByXpath(String locator) {
        return By.xpath(locator);
    }

    private WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(getByXpath(locator));
    }

    private List<WebElement> getListElement(WebDriver driver, String locator) {
        return driver.findElements(getByXpath(locator));
    }

    public void clickToElement(WebDriver driver, String locator) {
        getElement(driver, locator).click();
    }

    public void sendkeyToElement (WebDriver driver, String locator, String valueToSend) {
        getElement(driver, locator).sendKeys(valueToSend);
    }

    public void selectItemInDropdown (WebDriver driver, String locator, String textItem){
        new Select(getElement(driver, locator)).selectByVisibleText(textItem);
    }

    public String getSelectedItemInDropdown (WebDriver driver, String locator){
        return new Select(getElement(driver, locator)).getFirstSelectedOption().getText();
    }

    public boolean isDropdownMultiple(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator)).isMultiple();
    }

    public void selectItemInEditableDropdown(WebDriver driver, String editableXpath, String childXpath, String expectedTextItem) {
        getElement(driver, editableXpath).clear();
        getElement(driver, editableXpath).sendKeys(expectedTextItem);
        sleepInSecond(1);

        List<WebElement> allItems = new WebDriverWait(driver, longTimeout).until(ExpectedConditions.
                presenceOfAllElementsLocatedBy(By.xpath(childXpath)));

        for (WebElement temp : allItems) {
            String textItem = temp.getText();
            if (textItem.equals(expectedTextItem)){
                temp.click();
                sleepInSecond(1);
                break;
            }
        }
    }

    public void selectItemInSelectableDropdown(WebDriver driver, String parentXpath, String childXpath, String expectedTextItem) {

        getElement(driver, parentXpath).click();

        List<WebElement> allItems = new WebDriverWait(driver, longTimeout).until(ExpectedConditions.
                presenceOfAllElementsLocatedBy(By.xpath(childXpath)));

        for (WebElement temp : allItems) {
            String textItem = temp.getText();
            if (textItem.equals(expectedTextItem)){
                temp.click();
                sleepInSecond(1);
                break;
            }
        }
    }

    public String getElementText (WebDriver driver, String locator){
        return getElement(driver, locator).getText();
    }

    public String getElementDomAttribute (WebDriver driver, String locator, String attributeName){
        return getElement(driver, locator).getDomAttribute(attributeName);
    }

    public String getElementDomProperty (WebDriver driver, String locator, String propertyName){
        return getElement(driver, locator).getDomAttribute(propertyName);
    }

    public String getElementCss (WebDriver driver, String locator, String propertyName){
        return getElement(driver, locator).getCssValue(propertyName);
    }

    public String getElementHexaColor (WebDriver driver, String rgbaValue){
        return Color.fromString(rgbaValue).asHex().toUpperCase();
    }

    public int getListElementSize (WebDriver driver, String locator) {
        return getListElement(driver,locator).size();
    }

    public boolean isElementDisplay (WebDriver driver, String locator) {
        return getElement(driver, locator).isDisplayed();
    }

    public boolean isElementEnable (WebDriver driver, String locator) {
        return getElement(driver, locator).isEnabled();
    }

    public boolean isElementSelected (WebDriver driver, String locator) {
        return getElement(driver, locator).isSelected();
    }

    public void checkToCheckboxRadio (WebDriver driver, String locator) {
        if (!isElementSelected(driver, locator)){
            clickToElement(driver, locator);
        }
    }

    public void uncheckToCheckbox (WebDriver driver, String locator) {
        if (isElementSelected(driver, locator)){
            clickToElement(driver, locator);
        }
    }

    public void switchToFrame(WebDriver driver, String locator) {
        driver.switchTo().frame(getElement(driver, locator));
    }

    public void switchToDefaultContent(WebDriver driver){
        driver.switchTo().defaultContent();
    }

    public void leftClickToElement (WebDriver driver, String locator){
        new Actions(driver).click(getElement(driver, locator)).perform();
    }

    public void doubleClickToElement (WebDriver driver, String locator){
        new Actions(driver).doubleClick(getElement(driver, locator)).perform();
    }

    public void hoverToElement (WebDriver driver, String locator){
        new Actions(driver).moveToElement(getElement(driver, locator)).perform();
    }

    public void rightClickToElement (WebDriver driver, String locator){
        new Actions(driver).contextClick(getElement(driver, locator)).perform();
    }

    public void dragAndDropToElement (WebDriver driver, String sourceLocator, String targetLocator){
        new Actions(driver).dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
    }

    public void scrollToElement (WebDriver driver, String locator){
        new Actions(driver).scrollToElement(getElement(driver, locator)).perform();
    }


    public void highlightElement(WebDriver driver, String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getElement(driver, locator);
        String originalStyle = getElement(driver, locator).getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, locator));
        sleepInSecond(3);
    }

    public void scrollToElementOnTop(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
    }

    public void scrollToElementOnDown(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getElement(driver, locator));
    }

    public String getElementValidationMessage(WebDriver driver, String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
    }

    public WebElement waitElementVisible(WebDriver driver, String locator) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
    }

    public List<WebElement> waitListElementVisible(WebDriver driver, String locator) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
    }

    public boolean waitElementInvisible(WebDriver driver, String locator) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
    }

    public boolean waitListElementInvisible(WebDriver driver, String locator) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.invisibilityOfAllElements(getListElement(driver, locator)));
    }

    public WebElement waitElementPresence(WebDriver driver, String locator) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.presenceOfElementLocated(getByXpath(locator)));
    }

    public List<WebElement> waitListElementPresence(WebDriver driver, String locator) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(locator)));
    }

    public boolean waitElementSelected(WebDriver driver, String locator) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.elementToBeSelected(getByXpath(locator)));
    }

    public WebElement waitElementClickable(WebDriver driver, String locator) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
    }

    public boolean isLoadingIconDisappear(WebDriver driver) {
        return waitListElementInvisible(driver,"//div[contains(@class,'oxd-loading-spinner')]");
    }

    public AdminLoginPO openAdminPage(WebDriver driver , String adminUrl) {
        openPageUrl(driver, adminUrl);
        return PageGeneration.getPage(AdminLoginPO.class,driver);
    }

    public UserHomePO openUserPage(WebDriver driver, String userUrl) {
        openPageUrl(driver, userUrl);
        return PageGeneration.getPage(UserHomePO.class, driver);
    }

    private Duration shortTimeout = Duration.ofSeconds(10);
    private Duration longTimeout = Duration.ofSeconds(30);
}
