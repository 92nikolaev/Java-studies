package by.lesson17.Builder;

public class Main {
    public static void main(String[] args){
        HouseBuilder houseBuilder = new HouseBuilder();
        houseBuilder.setAddress("Орловская 4");
        House house1 = houseBuilder.build();
        houseBuilder.setAddress("Орловская 40");
        House house2=houseBuilder.build();
        //all houses should have the same number of entrances and levels; the only variable thing is address
        System.out.println(house1);
        System.out.println(house2);
    }
}
