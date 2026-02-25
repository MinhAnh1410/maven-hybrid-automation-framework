package factoryPattern;

public class Huyndai extends CarFactory{
    @Override
    public void viewCar() {
        System.out.println("View Huyndai Car");
    }

    @Override
    public void driveCar() {
        System.out.println("Drive Huyndai Car");
    }

    @Override
    public void buyCar() {
        System.out.println("Buy Huyndai Car");
    }
}
