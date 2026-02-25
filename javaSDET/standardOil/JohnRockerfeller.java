package standardOil;

public class JohnRockerfeller {

    // thuộc tính
    public String companyName = "Standard Oil Company";
    public String companyProduct = "E95 Oil";

    String companyPolicy = "Rockerfeller Salary Tax Cash";

    protected String rockerFriendship = "Abraham Lincoln President";

    private String keySecret = "ROCK-2025-***";

    // phương thức
    public void viewCompany() {
        System.out.println(companyName);
    }

    void viewPolicy() {
        System.out.println(companyPolicy);
    }

    protected void viewFriendship() {
        System.out.println(rockerFriendship);
    }

    private void viewkeySecret() {
        System.out.println(keySecret);
    }

    public static void main(String[] args) {
        JohnRockerfeller john = new JohnRockerfeller();
        john.viewCompany();
        john.viewPolicy();
        john.viewFriendship();
        john.viewkeySecret();
    }

}
