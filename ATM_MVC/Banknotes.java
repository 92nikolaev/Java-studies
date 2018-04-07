package com.gmail.slshukevitch;



class Banknotes  {
    private int numberOf50;
    private int numberOf100;
    private int numberOf20;
    private int numberOf10;
    private int numberOf5;




    public int getNumberOf50() {
        return numberOf50;
    }

    public void setNumberOf50(int numberOf50) {
        this.numberOf50 = numberOf50;

    }

    public int getNumberOf100() {
        return numberOf100;
    }

    public void setNumberOf100(int numberOf100) {
        this.numberOf100 = numberOf100;
    }

    public int getNumberOf20() {
        return numberOf20;
    }

    public void setNumberOf20(int numberOf20) {
        this.numberOf20 = numberOf20;
    }

    public int getNumberOf10() {
        return numberOf10;
    }

    public void setNumberOf10(int numberOf10) {
        this.numberOf10 = numberOf10;
    }

    public int getNumberOf5() {
        return numberOf5;
    }

    public void setNumberOf5(int numberOf5) {
        this.numberOf5 = numberOf5;
    }

    public int getTotalSum(){

        int totalSum =
                5 * numberOf5 +
                10 * numberOf10 +
                20 * numberOf20 +
                50 * numberOf50 +
                100 * numberOf100;

        return  totalSum;
    }
}
