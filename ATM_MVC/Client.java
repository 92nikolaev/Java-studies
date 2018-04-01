package by.lesson15.myVersion;

public class Client implements Runnable {
private int cash;
private ATM atm;

public Client(ATM atm){
    this.atm = atm;
}

public int getCash(){
    int random = (int )(Math.random() * 1000 + 10);
    return random;
}

    @Override
    public void run() {
        
    }
}
