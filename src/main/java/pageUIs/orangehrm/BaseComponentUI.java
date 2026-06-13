package pageUIs.orangehrm;

public class BaseComponentUI {

    public static final String TEXTBOX_BY_NAME = "XPath=//input[@name='%s']";
    public static final String TEXTBOX_BY_LABEL = "XPath=//label[contains(text(),'%s')]/parent::div/following-sibling::div/input";
    public static final String BUTTON_BY_TEXT = "XPath=//button[contains(string(),'%s')]";
    public static final String MODULE_BY_TEXT = "XPath=//span[text()='%s']/parent::a";
}
