package components;

import componentUIs.ModuleComponentUI;
import core.BaseComponent;
import org.openqa.selenium.WebDriver;
import pageUIs.orangehrm.BaseComponentUI;

public class ModuleComponent extends BaseComponent {

    private WebDriver driver;
    public ModuleComponent(WebDriver driver) {
        super(driver);
    }

    public void openModuleByText(String moduleName) {
        waitElementClickable(driver, ModuleComponentUI.MODULE_BY_TEXT, moduleName);
        clickToElement(driver, ModuleComponentUI.MODULE_BY_TEXT, moduleName);
    }
}
