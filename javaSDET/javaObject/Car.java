package javaObject;

public abstract class Car {

    // Abstract Method
    // bắt buộc phải override
    public abstract void viewCar();

    // Non-abstract Method
    // CHo lớp con (sub-class) sử dụng trực tiếp
    // Cũng cho phép override lại
    public void driveCar() {

    }


}
