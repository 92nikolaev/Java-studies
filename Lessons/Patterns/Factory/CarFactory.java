package by.lesson16;

public class CarFactory {

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
         Car car1 = buildCar(CarType.SMALL);
         Car car2 = buildCar(CarType.SEDAN);
         System.out.println(car1.getClass());
         System.out.println(car2.getModel());
    }

}
