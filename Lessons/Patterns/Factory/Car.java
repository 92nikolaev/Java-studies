package by.lesson16;

public class Car {
private CarType model;

    public Car(CarType model) {
        this.model = model;
    }

    public Car(){

    }


    public CarType getModel(){
        return model;
    }

    public void setModel(CarType model) {
        this.model = model;
    }

    protected void construct(){

    }

}
