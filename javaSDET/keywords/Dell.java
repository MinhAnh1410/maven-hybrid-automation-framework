package keywords;

public class Dell extends NetWorking implements IComputer{

    String ssd = "Samsung 990";

    public Dell(String ssd) {
        // trong hàm khởi tạo của lớp con phải gọi qua hàm khởi tạo của lớp cha = super
        super("Router");

        System.out.println(ssd);
        System.out.println(this.ssd);
    }
}
