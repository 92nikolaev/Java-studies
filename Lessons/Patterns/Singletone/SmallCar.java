package by.lesson17;

public class SmallCar extends Car {

    SmallCar(){
        super(CarType.SMALL);
    }

    protected void construct(){
        System.out.println("Small car created");
    }

}