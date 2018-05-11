package com.gmail.slshukevitch;

public class View {
    private ATM atm;

    public View(ATM atm){
        this.atm = atm;
    }

    public void printCashAvailable(){

        System.out.println("В банкомате присутствует "+atm.getTotalSum() + " рублей");
    }

}
