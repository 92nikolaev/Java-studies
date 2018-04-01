package by.lesson15.myVersion;

public class Cashier extends Controller {
      Banknotes fillATM(int numberOf5, int numberOf10, int numberOf20, int numberOf50, int numberOf100) {
        Banknotes banknotes = new Banknotes();
        banknotes.setNumberOf5(numberOf5);
        banknotes.setNumberOf10(numberOf10);
        banknotes.setNumberOf20(numberOf20);
        banknotes.setNumberOf50(numberOf50);
        banknotes.setNumberOf100(numberOf100);
        return banknotes;

    }


}
