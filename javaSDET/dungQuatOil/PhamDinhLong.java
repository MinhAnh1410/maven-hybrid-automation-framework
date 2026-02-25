package dungQuatOil;

import standardOil.JohnRockerfeller;

public class PhamDinhLong {
    public static void main(String[] args) {
        JohnRockerfeller john = new JohnRockerfeller();
        System.out.println(john.companyName);
        System.out.println(john.companyProduct);

        john.viewCompany();
        // john.viewPolicy();
        // john.viewKeySecret();
    }
}
