package by.lesson17;
/*
SINGLETONE CLASS EXAMPLE
 */

public class CarFactory {

    private static volatile CarFactory carFactory;
    //volatile - if class has been created, all threads should know about it

    private CarFactory(){
        carFactory = new CarFactory();
    }

        //Singletone implementation

    public static CarFactory getInstance(){ //synchronized is a must for multithreaded task
        if (carFactory == null){
            synchronized (CarFactory.class){  //lock at class level, i.e. static
                carFactory = new CarFactory();
            }
        }
        return carFactory;
    }

    public static Car buildCar(CarType model) {
        Car car = null;

        switch (model) {
            case SEDAN:
                car = new SedanCar();
                car.setModel(CarType.SEDAN);
                car.construct();
                break;

            case SMALL:

                car = new SmallCar();
                car.setModel(CarType.SMALL);
                car.construct();
                break;


            case LUXURY:
                car = new LuxuryCar();
                car.setModel(CarType.LUXURY);
                car.construct();
                break;
        }

        return car;
    }

    public static void main(String[] args) {
        CarFactory.getInstance();
         Car car1 = buildCar(CarType.SMALL);
         Car car2 = buildCar(CarType.SEDAN);
         System.out.println(car1.getClass());
         System.out.println(car2.getModel());
    }

}
