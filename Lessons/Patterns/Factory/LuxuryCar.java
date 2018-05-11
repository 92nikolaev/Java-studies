package by.lesson16;

public class LuxuryCar extends Car {

    LuxuryCar() {
        super(CarType.LUXURY);
    }

    protected void construct() {
        System.out.println("WOW LUXURY car created");
    }
}
