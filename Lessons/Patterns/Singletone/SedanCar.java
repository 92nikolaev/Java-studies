package by.lesson17;

public class SedanCar extends Car {

    SedanCar() {
        super(CarType.SEDAN);

    }

    protected void construct() {
        System.out.println("Sedan car created");
    }


}
