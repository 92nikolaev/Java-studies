package by.lesson17.Builder;


public final class House {

    private int levelNumber;
    private int enterNumber;
    private String address;

    House() {

    }

    void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    void setEnterNumber(int enterNumber) {
        this.enterNumber = enterNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public int getEnterNumber() {
        return enterNumber;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return super.toString() + "address: " + address
                + " levels: " + levelNumber
                + " entrances: " + enterNumber;
    }


}
