package dungQuatOil;

import standardOil.JohnRockerfeller;

public class NelsonRockerfeller extends JohnRockerfeller {

    public static void main(String[] args) {
        NelsonRockerfeller nelson = new NelsonRockerfeller();
        nelson.viewCompanyName();
    }

    public void viewCompanyName() {
        viewCompany();
    }
}
