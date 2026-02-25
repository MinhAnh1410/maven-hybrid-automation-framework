package factoryPattern;

public class VinFast extends CarFactory{
    @Override
    public void viewCar() {
        System.out.println("View VinFast Car");
    }

    @Override
    public void driveCar() {
        System.out.println("Drive VinFast Car");
    }

    @Override
    public void buyCar() {
        System.out.println("Buy VinFast Car");
    }
}
