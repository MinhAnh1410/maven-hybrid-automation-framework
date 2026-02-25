package pageFactory.orangehrm;

import core.BasePage;
import core.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pageUIs.orangehrm.LoginUI;

public class LoginPO extends BasePageFactory {
    private WebDriver driver;

    // gắn annotations cho các biến
    @CacheLookup
    // dùng khi muốn tìm 1 lần và sử dụng lại
    @FindBy(how = How.CSS, using = "input[name='username']")
    private WebElement usernameTextbox;

    @FindBy(css = "input[name='password']")
    private WebElement passwordTextbox;

    @FindBy(css = "button.orangehrm-login-button")
    private WebElement loginButton;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterToUsernameTextbox(String userName) {
        waitElementVisible(driver, usernameTextbox);
        sendkeyToElement(driver, usernameTextbox, userName);
    }

    public void enterToPasswordTextbox(String password) {
        waitElementVisible(driver, passwordTextbox);
        sendkeyToElement(driver, passwordTextbox, password);
    }

    public void clickToLoginButton() {
        waitElementClickable(driver, loginButton);
        clickToElement(driver, loginButton);
    }
}
