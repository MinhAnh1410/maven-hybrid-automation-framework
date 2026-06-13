package components;

import componentUIs.ButtonComponentUI;
import core.BaseComponent;
import org.openqa.selenium.WebDriver;

public class ButtonComponent extends BaseComponent {

    private WebDriver driver;
    public ButtonComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToButtonByText(String buttonText) {
        waitElementClickable(driver, ButtonComponentUI.BUTTON_BY_TEXT, buttonText);
        clickToElement(driver, ButtonComponentUI.BUTTON_BY_TEXT, buttonText);
    }

}
