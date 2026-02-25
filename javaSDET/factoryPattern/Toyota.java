package factoryPattern;

public class Toyota extends CarFactory{
    @Override
    public void viewCar() {
        System.out.println("View Toyota Car");
    }

    @Override
    public void driveCar() {
        System.out.println("Drive Toyota Car");
    }

    @Override
    public void buyCar() {
        System.out.println("Buy Toyota Car");
    }
}
