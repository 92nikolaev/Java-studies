package com.gmail.slshukevitch;


public class ATM extends Banknotes {
    Banknotes banknotes;

    public ATM(Banknotes banknotes){
        this.banknotes = banknotes;
    }

   public int getTotalSum(){

        int totalSum =
                5 * banknotes.getNumberOf5() +
                        10 * banknotes.getNumberOf10() +
                        20 * banknotes.getNumberOf20() +
                        50 * banknotes.getNumberOf50()+
                        100 * banknotes.getNumberOf100();

        return  totalSum;
    }
}
