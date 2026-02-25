package factoryPattern;

public class EndUser {
    public static void main(String[] args) {
        CarFactory car;

        // xem xe Honda
        car = getCar("Honda");
        car.viewCar();
        car.driveCar();
        car.buyCar();

    }

    public static CarFactory getCar(String carName) {
        CarFactory carFactory = null;
        switch (carName) {
            case "Honda":
                carFactory = new Honda();
                break;
            case "Huyndai":
                carFactory = new Huyndai();
                break;
            case "Toyota":
                carFactory = new Toyota();
                break;
            case "VinFast":
                carFactory = new VinFast();
                break;
        }

        return carFactory;
    }
}
