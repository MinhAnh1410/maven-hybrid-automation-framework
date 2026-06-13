package core;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.PageGeneration;
import pageObjects.techpanda.admin.AdminLoginPO;
import pageObjects.techpanda.admin.AdminOrderPO;
import pageObjects.techpanda.user.UserHomePO;
import pageUIs.BasePageUI;

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

    public String getCurrentWindowID(WebDriver driver) {
        return driver.getWindowHandle();
    }

    public void switchToNewTabByUrl(WebDriver driver, String url) {
        driver.switchTo().newWindow(WindowType.TAB).get(url);
    }

    public void switchToNewTabByWindow (WebDriver driver, String url) {
        driver.switchTo().newWindow(WindowType.WINDOW).get(url);
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

    private String castParams(String locator, String ... value) {
        return String.format(locator, (Object[]) value);
    }

    private static By getByXpath(String locator) {
        return By.xpath(locator);
    }

    private By getByLocator(String locatorType) {
        if (locatorType == null || locatorType.trim().isEmpty()) {
            throw new IllegalArgumentException("Locator type cannot be null or empty.");
        }

        String[] locatorArr = locatorType.split("=", 2);
        String locatorValue = locatorArr[1].trim();

        switch (locatorArr[0].trim().toUpperCase()) {
            case "ID":
                return By.id(locatorValue);
            case "CLASS":
                return By.className(locatorValue);
            case "NAME":
                return By.name(locatorValue);
            case "TAG":
                return By.tagName(locatorValue);
            case "LINK":
                return By.linkText(locatorValue);
            case "PARTIAL":
                return By.partialLinkText(locatorValue);
            case "CSS":
                return By.cssSelector(locatorValue);
            case "XPATH":
                return By.xpath(locatorValue);
            default:
                throw new IllegalArgumentException("Locator type is not supported: " + locatorType);
        }
    }

    private WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(getByLocator(locator));
    }

    public List<WebElement> getListElement(WebDriver driver, String locator) {
        return driver.findElements(getByLocator(locator));
    }

    public List<WebElement> getListElement(WebDriver driver, String locator, String... value) {
        return driver.findElements(getByLocator(castParams(locator, value)));
    }

    public void clickToElement(WebDriver driver, String locator) {
        getElement(driver, locator).click();
    }

    public void clickToElement(WebDriver driver, String locator, String... value) {
        getElement(driver, castParams(locator, value)).click();
    }

    public void sendkeyToElement (WebDriver driver, String locator, String valueToSend) {
        getElement(driver, locator).clear();
        getElement(driver, locator).sendKeys(valueToSend);
    }

    public void sendkeyToElement (WebDriver driver, String locator, String valueToSend, String... value) {
        getElement(driver, castParams(locator,value)).sendKeys(valueToSend);
    }

    public void selectItemInDropdown (WebDriver driver, String locator, String textItem){
        new Select(getElement(driver, locator)).selectByVisibleText(textItem);
    }

    public void selectItemInDropdown (WebDriver driver, String locator, String textItem, String... value){
        new Select(getElement(driver, castParams(locator, value))).selectByVisibleText(textItem);
    }

    public String getSelectedItemInDropdown (WebDriver driver, String locator){
        return new Select(getElement(driver, locator)).getFirstSelectedOption().getText();
    }

    public String getSelectedItemInDropdown (WebDriver driver, String locator, String... value){
        return new Select(getElement(driver, castParams(locator, value))).getFirstSelectedOption().getText();
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

    public String getElementText (WebDriver driver, String locator, String... value){
        return getElement(driver, castParams(locator, value)).getText();
    }

    public String getElementDomAttribute (WebDriver driver, String locator, String attributeName){
        return getElement(driver, locator).getDomAttribute(attributeName);
    }

    public String getElementDomAttribute (WebDriver driver, String locator, String attributeName, String... value){
        return getElement(driver, castParams(locator, value)).getDomAttribute(attributeName);
    }

    public String getElementDomProperty (WebDriver driver, String locator, String propertyName){
        return getElement(driver, locator).getDomAttribute(propertyName);
    }

    public String getElementDomProperty (WebDriver driver, String locator, String propertyName, String... value){
        return getElement(driver, castParams(locator, value)).getDomAttribute(propertyName);
    }

    public String getElementCss (WebDriver driver, String locator, String propertyName){
        return getElement(driver, locator).getCssValue(propertyName);
    }

    public String getElementCss (WebDriver driver, String locator, String propertyName, String... value){
        return getElement(driver, castParams(locator, value)).getCssValue(propertyName);
    }

    public String getElementHexaColor (WebDriver driver, String rgbaValue){
        return Color.fromString(rgbaValue).asHex().toUpperCase();
    }

    public int getListElementSize (WebDriver driver, String locator) {
        return getListElement(driver,locator).size();
    }

    public int getListElementSize (WebDriver driver, String locator, String... value) {
        return getListElement(driver,castParams(locator, value)).size();
    }

    private void overideImplicitWait(WebDriver driver, long timeInSecond) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSecond));
    }

    public boolean isElementDisplay (WebDriver driver, String locator) {
        try {
            // TH1: Element có hiển thị ở UI và có xuất hiện trong DOM (Visible/ Displayed) => true
            // TH2: Element không hiển thị trên UI và có trong DOM (Invisible) => false
            return getElement(driver, locator).isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    // Cách 2: Sử dụng try-catch ( có overide timeout)
    public boolean isElementNotPresence (WebDriver driver, String locator) {
        try {
            overideImplicitWait(driver, GlobalConstants.SHORT_TIMEOUT);
            List<WebElement> elements = getListElement(driver, locator);
            if (elements.isEmpty()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        } finally {
            overideImplicitWait(driver, GlobalConstants.LONG_TIMEOUT);
        }
    }

    // Cách 1: Ko sử dụng try-catch ( có overide timeout)
    public boolean isElementNonPresence (WebDriver driver, String locator) {
        overideImplicitWait(driver, GlobalConstants.SHORT_TIMEOUT);
        List<WebElement> elements = getListElement(driver, locator);
        overideImplicitWait(driver, GlobalConstants.LONG_TIMEOUT);
        if (elements.size() == 0) {
            // TH3: Element không hiển thị trên UI và không có trong DOM (Invisible)
            return true;
        } else {
            // TH1: Element có hiển thị ở UI và có xuất hiện trong DOM (Visible/ Displayed) => true
            // TH2: Element không hiển thị trên UI và có trong DOM (Invisible) => false
            return false;
        }
    }

    // Cách 3: Ko cần overide timeout/ findElements check empty
    public boolean isElementNonePresence (WebDriver driver, String locator) {
        try {
            overideImplicitWait(driver, 0);
            return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                    .until(ExpectedConditions.numberOfElementsToBe(getByLocator(locator),0)).isEmpty();
        } catch (Exception e) {
            return false;
        } finally {
            overideImplicitWait(driver, GlobalConstants.LONG_TIMEOUT);
        }
    }

    public boolean isElementHidden (WebDriver driver, String locator) {
        List<WebElement> elements = getListElement(driver, locator);
        if (elements.size() >= 0 && !elements.getFirst().isDisplayed()) {
            // TH2: Element không hiển thị trên UI và có trong DOM (Invisible) => false
            return true;
        } else {
            // TH1: Element có hiển thị ở UI và có xuất hiện trong DOM (Visible/ Displayed) => true
            // TH3: Element không hiển thị trên UI và không có trong DOM (Invisible)
            return false;
        }
    }

    public boolean isElementDisplay (WebDriver driver, String locator, String... value) {
        return getElement(driver, castParams(locator, value)).isDisplayed();
    }

    public boolean isElementEnable (WebDriver driver, String locator) {
        return getElement(driver, locator).isEnabled();
    }

    public boolean isElementEnable (WebDriver driver, String locator, String... value) {
        return getElement(driver, castParams(locator, value)).isEnabled();
    }

    public boolean isElementSelected (WebDriver driver, String locator) {
        return getElement(driver, locator).isSelected();
    }

    public boolean isElementSelected (WebDriver driver, String locator, String... value) {
        return getElement(driver, castParams(locator, value)).isSelected();
    }

    public void checkToCheckboxRadio (WebDriver driver, String locator) {
        if (!isElementSelected(driver, locator)){
            clickToElement(driver, locator);
        }
    }

    public void checkToCheckboxRadio (WebDriver driver, String locator, String... value) {
        if (!isElementSelected(driver, castParams(locator, value))){
            clickToElement(driver, castParams(locator, value));
        }
    }

    public void uncheckToCheckbox (WebDriver driver, String locator) {
        if (isElementSelected(driver, locator)){
            clickToElement(driver, locator);
        }
    }

    public void uncheckToCheckbox (WebDriver driver, String locator, String... value) {
        locator = castParams(locator, value);
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

    public void hoverToElement (WebDriver driver, String locator, String... value){
        new Actions(driver).moveToElement(getElement(driver, castParams(locator, value))).perform();
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
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void highlightElement(WebDriver driver, String locator, String... value) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getElement(driver, castParams(locator, value));
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, locator));
        sleepInSecond(3);
    }

    public void clickToElementByJS(WebDriver driver, String locator, String... value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, castParams(locator, value)));
        sleepInSecond(3);
    }

    public void scrollToElementOnTop(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
    }

    public void scrollToElementOnTop(WebDriver driver, String locator, String... value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver, castParams(locator, value)));
    }

    public void scrollToElementOnDown(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getElement(driver, locator));
    }

    public String getElementValidationMessage(WebDriver driver, String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
    }

    public String getElementValidationMessage(WebDriver driver, String locator, String... value) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getElement(driver, castParams(locator, value)));
    }

    public WebElement waitElementVisible(WebDriver driver, String locator) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }

    public WebElement waitElementVisible(WebDriver driver, String locator, String... value) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.visibilityOfElementLocated(getByLocator(castParams(locator, value))));
    }

    public List<WebElement> waitListElementVisible(WebDriver driver, String locator) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locator)));
    }

    public List<WebElement> waitListElementVisible(WebDriver driver, String locator, String... value) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(castParams(locator, value))));
    }

    public boolean waitElementInvisible(WebDriver driver, String locator) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }

    public boolean waitElementInvisible(WebDriver driver, String locator, String... value) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(castParams(locator,value))));
    }

    public boolean waitListElementInvisible(WebDriver driver, String locator) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.invisibilityOfAllElements(getListElement(driver, locator)));
    }

    public boolean waitListElementInvisible(WebDriver driver, String locator, String... value) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.invisibilityOfAllElements(getListElement(driver, castParams(locator, value))));
    }

    public WebElement waitElementPresence(WebDriver driver, String locator) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.presenceOfElementLocated(getByLocator(locator)));
    }

    public WebElement waitElementPresence(WebDriver driver, String locator, String... value) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.presenceOfElementLocated(getByLocator(castParams(locator, value))));
    }

    public List<WebElement> waitListElementPresence(WebDriver driver, String locator) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(locator)));
    }

    public List<WebElement> waitListElementPresence(WebDriver driver, String locator, String... value) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(castParams(locator, value))));
    }

    public boolean waitElementSelected(WebDriver driver, String locator) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.elementToBeSelected(getByLocator(locator)));
    }

    public boolean waitElementSelected(WebDriver driver, String locator, String... value) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.elementToBeSelected(getByLocator(castParams(locator, value))));
    }

    public WebElement waitElementClickable(WebDriver driver, String locator) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }

    public WebElement waitElementClickable(WebDriver driver, String locator, String... value) {
        return new WebDriverWait(driver, longTimeout)
                .until(ExpectedConditions.elementToBeClickable(getByLocator(castParams(locator,value))));
    }

    public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
        String filePath = GlobalConstants.UPLOAD_PATH;
        String fullFileName = "";
        for (String file : fileNames) {
            fullFileName = fullFileName + filePath + file + "\n";
        }
        getElement(driver, BasePageUI.UPLOAD_FILE_TYPE).sendKeys(fullFileName.trim());
    }

    /*------ Orange HRM Site -------*/
    @Step("Verify loading icon invisible")
    public boolean isLoadingIconDisappear(WebDriver driver) {
        return waitListElementInvisible(driver,"XPath=//div[contains(@class,'oxd-loading-spinner')]");
    }

    /*------ Tech Panda Site -------*/
    public AdminLoginPO openAdminPage(WebDriver driver , String adminUrl) {
        openPageUrl(driver, adminUrl);
        return PageGeneration.getPage(AdminLoginPO.class,driver);
    }

    public UserHomePO openUserPage(WebDriver driver, String userUrl) {
        openPageUrl(driver, userUrl);
        return PageGeneration.getPage(UserHomePO.class, driver);
    }

    public AdminOrderPO openOrderPage(WebDriver driver) {
        waitElementClickable(driver, BasePageUI.ADMIN_SALE_PAGE);
        hoverToElement(driver, BasePageUI.ADMIN_SALE_PAGE);
        waitElementClickable(driver, BasePageUI.ADMIN_ORDER_PAGE);
        clickToElement(driver, BasePageUI.ADMIN_ORDER_PAGE);
        return PageGeneration.getPage(AdminOrderPO.class, driver);
    }

    public UserHomePO logoutToUserPage(WebDriver driver) {
        waitElementClickable(driver, BasePageUI.USER_HEADER_ACCOUNT_TEXT);
        clickToElement(driver, BasePageUI.USER_HEADER_ACCOUNT_TEXT);

        waitElementClickable(driver, BasePageUI.USER_HEADER_LOGOUT_LINK);
        clickToElement(driver, BasePageUI.USER_HEADER_LOGOUT_LINK);
        sleepInSecond(6);
        return PageGeneration.getPage(UserHomePO.class, driver);
    }

    public AdminLoginPO logoutToAdminPage(WebDriver driver) {
        waitElementClickable(driver, BasePageUI.ADMIN_LOGOUT_LINK);
        clickToElement(driver, BasePageUI.ADMIN_LOGOUT_LINK);
        return PageGeneration.getPage(AdminLoginPO.class, driver);
    }

    private Duration shortTimeout = Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT);
    private Duration longTimeout = Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT);
}
