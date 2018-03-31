package by.lesson15.myVersion;

import by.lesson15.Banknote;

public class Main {
    public static void main(String [] args){
        // 1)load some banknotes
        Cashier cashier = new Cashier();
        Banknotes banknotesInATM = cashier.fillATM(100,100,100,50,20);
        ATM atm = new ATM(banknotesInATM);









    }
}
