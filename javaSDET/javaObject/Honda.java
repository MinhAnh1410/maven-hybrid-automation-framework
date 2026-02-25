package javaObject;

public class Honda extends Car{
    String hondaCivic;

    static void main(String[] args) {
        Honda honda = new Honda();
        honda.driveCar();

        Honda city = new Honda();
    }

    public void viewHondaCivic() {

    }

    // Non-Abstract class không chứa 1 abstract method
    // Abstract  method - hàm ko có phần thân
    // Sử dụng để cho các lớp con kế thừa phải implement lại
    // Thể hiện cho tính chất trừu tượng (Abstraction)
    // public abstract void driveHondaCivic();

    public final void driveHondaCivic() {

    }

    public void viewCar() {}
}
