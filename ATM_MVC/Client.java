package com.gmail.slshukevitch;



public class Client extends Controller implements Runnable  {
private int cash;
private ATM atm;
private Controller controller;

public Client(){
    this.atm = atm;
}
//TODO разобраться с тем, чтобы клиент брал деньги из нашего конкретного банкомата через контроллер. сейчас он хз откуда
    @Override
    public void run() {
        while (true) {
            int amount = (int)(Math.random()*1000)*10;
            try {
                controller.getCash(amount);
                Thread.currentThread().sleep(5000);
            }  catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
