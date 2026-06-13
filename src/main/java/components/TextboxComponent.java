package components;

import componentUIs.TextboxComponentUI;
import core.BaseComponent;
import org.openqa.selenium.WebDriver;

public class TextboxComponent extends BaseComponent {

    private WebDriver driver;
    public TextboxComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterToTextboxByName(String nameValue, String valueToSend) {
        waitElementVisible(driver, TextboxComponentUI.TEXTBOX_BY_NAME, nameValue);
        sendkeyToElement(driver, TextboxComponentUI.TEXTBOX_BY_NAME, valueToSend, nameValue);
    }

    public void enterToTextboxByLabel(String labelTextbox, String valueToSend) {
        waitElementVisible(driver, TextboxComponentUI.TEXTBOX_BY_LABEL, labelTextbox);
        sendkeyToElement(driver, TextboxComponentUI.TEXTBOX_BY_LABEL, valueToSend, labelTextbox);
    }

    public String getTextboxValueByLabel(String labelTextbox) {
        waitElementPresence(driver, TextboxComponentUI.TEXTBOX_BY_LABEL, labelTextbox);
        return getElementDomProperty(driver, TextboxComponentUI.TEXTBOX_BY_LABEL,"value", labelTextbox);
    }

    public String getTextboxValueByName(String textboxName) {
        waitElementPresence(driver, TextboxComponentUI.TEXTBOX_BY_NAME, textboxName);
        return getElementDomProperty(driver, TextboxComponentUI.TEXTBOX_BY_NAME,"value", textboxName);
    }

}
