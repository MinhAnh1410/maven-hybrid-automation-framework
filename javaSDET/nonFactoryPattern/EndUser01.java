package nonFactoryPattern;

public class EndUser01 {
    public static void main(String[] args) {
        // den dia diem xe honda
        Honda honda = new Honda();
        honda.viewCar();
        honda.driveCar();
        honda.buyCar();

        // den dia diem xe huyndai
        Huyndai huyn = new Huyndai();
        huyn.viewCar();
        huyn.driveCar();
        huyn.buyCar();

        // den dia diem xe huyndai
        VinFast vinf = new VinFast();
        vinf.viewCar();
        vinf.driveCar();
        vinf.buyCar();
    }
}
