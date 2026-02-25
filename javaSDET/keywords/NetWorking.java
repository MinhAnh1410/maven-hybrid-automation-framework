package keywords;

public class NetWorking {

    // sử dụng trong cùng 1 package
    String firewall = ""; // default

    // sử dụng trong phạm vi class này
    private String switchProduct = "";

    // sử dụng thông qua kế thừa
    protected String hubProduct = "";

    // dùng trong toàn bộ hệ thống/ framework
    public String routerProduct = "";

    // hàm khởi tạo
    public NetWorking(String productName) {

    }
}
