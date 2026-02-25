package pageObjects.orangehrm;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.orangehrm.LoginUI;

public class LoginPO extends BasePage {
    private WebDriver driver;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }
    // hàm khởi tạo - constructor method
    // hàm sẽ được gọi tới đầu tiên khi class được new loginPage = new LoginPO(driver);
    // khi ko define hàm khởi tại --> trình biên dịch tự tạo hàm khởi tạo rỗng
    // hàm khỏi tạo bắt buộc cùng tên class và ko cos kiểu trả về
    // 1 class có thể có 1/ nhiều hàm khởi tạo

    public void enterToUsernameTextbox(String userName) {
        // gọi các hàm trong BasePage để sử dụng, tránh viết đi viết lại
        waitElementVisible(driver, LoginUI.USERNAME_TEXTBOX);
        sendkeyToElement(driver, LoginUI.USERNAME_TEXTBOX, userName); // thông qua biến static để gọi đến hằng số đã khai báo
    }

    public void enterToPasswordTextbox(String password) {
        waitElementVisible(driver, LoginUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, LoginUI.PASSWORD_TEXTBOX, password);
    }

    public void clickToLoginButton() {
        waitElementClickable(driver, LoginUI.LOGIN_BUTTON);
        clickToElement(driver, LoginUI.LOGIN_BUTTON);
    }
}
