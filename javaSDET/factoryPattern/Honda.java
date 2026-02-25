package factoryPattern;

public class Honda extends CarFactory{
    @Override
    public void viewCar() {
        System.out.println("View Honda Car");
    }

    @Override
    public void driveCar() {
        System.out.println("Drive Honda Car");
    }

    @Override
    public void buyCar() {
        System.out.println("Buy Honda Car");
    }
}
