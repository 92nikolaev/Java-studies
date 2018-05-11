package by.lesson17.Builder;

public class HouseBuilder {

    private House prototype; //package scope, default access level

    public HouseBuilder() {
        prototype = new House();
        prototype.setEnterNumber(4);
        prototype.setLevelNumber(3);

    }

    public void setAddress(String address) {
        prototype.setAddress(address);
    }

    public House build() {
        House builtHouse = prototype;
        //WTF??
        prototype = new House(); //???
        //new object`s properties
        prototype.setEnterNumber(4);
        prototype.setLevelNumber(3);
        return builtHouse;

    }
}
