package dynamicLocator;

import org.testng.annotations.Test;

public class MultiplePage {
    @Test
    public void TC_01() {

        // 1 param
        String dynamicPage = "//a[text()='%s']";
        clickToPage(dynamicPage, "Dependent");

        // 2 param
        dynamicPage = "//td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='males' and text()='%s']";
        clickToPage(dynamicPage, "Algeria", "295140");


    }

    private void clickToPage(String locator, String pageName) {
        System.out.println("Click to Page: " + String.format(locator, pageName));
    }

    private void clickToPage(String locator, String country, String male) {
        System.out.println("Click to Page: " + String.format(locator, country, male));
    }

    // để thu gọn --> sử dụng ép kiểu các tham số liên quan
    // rest parameter = var arguments (java)
    // khai báo biến được nhận dạng qua ...
    // tham số này bắt buộc phải ở cuối cùng
    // ... là rút gọn của 1 mảng có kiểu dữ liệu giống nhau []
    private void clickToPage(String locator, String ... value) {
        System.out.println("Click to Page: " + String.format(locator, (Object) value));
    }
}
