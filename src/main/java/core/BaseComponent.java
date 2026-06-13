package core;

import org.openqa.selenium.WebDriver;
import pageUIs.orangehrm.BaseComponentUI;

public class BaseComponent extends BasePage{

    private WebDriver driver;
    public BaseComponent(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToTextboxByName(String nameValue, String valueToSend) {
        waitElementVisible(driver, BaseComponentUI.TEXTBOX_BY_NAME, nameValue);
        sendkeyToElement(driver, BaseComponentUI.TEXTBOX_BY_NAME, valueToSend, nameValue);
    }

    public void enterToTextboxByLabel(String labelTextbox, String valueToSend) {
        waitElementVisible(driver, BaseComponentUI.TEXTBOX_BY_LABEL, labelTextbox);
        sendkeyToElement(driver, BaseComponentUI.TEXTBOX_BY_LABEL, valueToSend, labelTextbox);
    }

    public String getTextboxValueByLabel(String labelTextbox) {
        waitElementPresence(driver, BaseComponentUI.TEXTBOX_BY_LABEL, labelTextbox);
        return getElementDomProperty(driver, BaseComponentUI.TEXTBOX_BY_LABEL,"value", labelTextbox);
    }

    public String getTextboxValueByName(String textboxName) {
        waitElementPresence(driver, BaseComponentUI.TEXTBOX_BY_NAME, textboxName);
        return getElementDomProperty(driver, BaseComponentUI.TEXTBOX_BY_NAME,"value", textboxName);
    }

    public void clickToButtonByText(String buttonText) {
        waitElementClickable(driver, BaseComponentUI.BUTTON_BY_TEXT, buttonText);
        clickToElement(driver, BaseComponentUI.BUTTON_BY_TEXT, buttonText);
    }

    public void openModuleByText(String moduleName) {
        waitElementClickable(driver, BaseComponentUI.MODULE_BY_TEXT, moduleName);
        clickToElement(driver, BaseComponentUI.MODULE_BY_TEXT, moduleName);
    }

}
