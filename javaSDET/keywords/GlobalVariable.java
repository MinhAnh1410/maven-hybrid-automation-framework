package keywords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GlobalVariable {

    // biến non-static
    String addressName = "HCM City";

    // biến tĩnh: static
    static String fullName = "Automation FC";

    // biến final
    final String firstName = "John";

    // biến static final
    static final String BROWSER_NAME = "Firefox";

    static void main() {
        // new: khởi tại 1 class lên = tạo ra 1 đối tượng/ instance
        // 1 class có theer tạo ra n đối tượng
        GlobalVariable globalVariable = new GlobalVariable();

        System.out.println(globalVariable instanceof GlobalVariable);

        // interface dùng qua cách implements chứ ko new

        // biến non-static: dùng thông qua 1 instance/ đối tượng đại diện cho class
        System.out.println(globalVariable.addressName);
        globalVariable.addressName = "HN City";

        // biến tĩnh static: lấy trực tiếp từ class
        System.out.println(fullName);

        // biến final: không cho phép ghi đè
        //globalVariable.firstName = "a";

        //biến static final: thuộc phạm vi class và không đc ghi đè

    }

    // gọi hàm tuần tự, ko đc phép truy cập cùng thời điểm
    public synchronized WebDriver getBrowserDriver() {
        WebDriver driver = new FirefoxDriver();
        return driver;
    }


}
