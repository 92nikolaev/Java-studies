package by.lesson15.myVersion;

import by.lesson15.Banknote;

public class Controller {
    Banknotes banknotes;

    public void initialLoad(){
        Cashier cashier = new Cashier();
        Banknotes banknotesInATM = cashier.fillATM(100,100,100,50,25);
        ATM atm = new ATM(banknotesInATM);
        View view = new View(atm);
        view.printCashAvailable();
        Client vasya = new Client(atm);
    }


    public void askCash(){

    }


    public ClientCash getCash(int value) {
            ClientCash clientCash=null; //initialise;

        //work with amount of money to give

        if ((value >= banknotes.getTotalSum()) || (value % 5 != 0) || (value <= 0)) {

            //if invalid value just return 0
            //and display error
            //then ask client to repeat

            clientCash.give5 = 0;
            clientCash.give10 = 0;
            clientCash.give20 = 0;
            clientCash.give50 = 0;
            clientCash.give100 = 0;
            clientCash.isValid = false;

        } else if (value % 100 == 0) {
            clientCash.give5 = 0;
            clientCash.give10 = 0;
            clientCash.give20 = 0;
            clientCash.give50 = 0;
            clientCash.give100 = value / 100;
            clientCash.isValid = true;

        } else if (value % 50 == 0) {
            clientCash.give5 = 0;
            clientCash.give10 = 0;
            clientCash.give20 = 0;
            clientCash.give50 = (value - 100 * clientCash.give100) / 50;
            clientCash.give100 = value / 100;
            clientCash.isValid = true;

        } else if (value % 20 == 0) {
            clientCash.give5 = 0;
            clientCash.give10 = 0;
            clientCash.give20 = (value - 100 * clientCash.give100) / 50;
            clientCash.give50 = (value - 100 * clientCash.give100) / 50;
            clientCash.give100 = value / 100;
            clientCash.isValid = true;

        }

        else if (value % 10 == 0) {
            clientCash.give5 = 0;
            clientCash.give10 = (value - (100 * clientCash.give100 + 50 * clientCash.give50 + 20 * clientCash.give20)) / 10;
            clientCash.give20 = (value - 100 * clientCash.give100) / 50;
            clientCash.give50 = (value - 100 * clientCash.give100) / 50;
            clientCash.give100 = value / 100;
            clientCash.isValid = true;

        }

        else if (value % 5 == 0) {
            clientCash.give5 = (value - (100 * clientCash.give100 + 50 * clientCash.give50 + 20 * clientCash.give20 + 10 * clientCash.give10)) / 5;
            clientCash.give10 = (value - (100 * clientCash.give100 + 50 * clientCash.give50 + 20 * clientCash.give20)) / 10;
            clientCash.give20 = (value - 100 * clientCash.give100) / 50;
            clientCash.give50 = (value - 100 * clientCash.give100) / 50;
            clientCash.give100 = value / 100;
            clientCash.isValid = true;

        }

        //if there are no banknotes of certain value

        else if (clientCash.give100 >= banknotes.getNumberOf100() ||
                clientCash.give50 >= banknotes.getNumberOf50() ||
                clientCash.give20 >= banknotes.getNumberOf20() ||
                clientCash.give10 >= banknotes.getNumberOf10() ||
                clientCash.give5 >= banknotes.getNumberOf5()) {
            clientCash.isValid=false;
        }

        return clientCash;

    }
}
