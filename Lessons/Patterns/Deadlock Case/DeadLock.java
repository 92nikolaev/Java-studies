package by.lesson15;

public class DeadLock {

    public void method1() {
        synchronized (String.class) {
            System.out.println(Thread.currentThread().getName()
                    + " Acquired lock on String.class object");
            synchronized (Integer.class) {
                System.out.println(Thread.currentThread().getName()
                        + " Aquired lock on Integer.class object");
            }
        }
    }

    public void method2() {
        synchronized (Integer.class) {
            System.out.println(Thread.currentThread().getName()
                    + " Acquired lock on Integer.class object");
            synchronized (String.class) {
                System.out.println(Thread.currentThread().getName()
                        + " Acquired lock on String.class object");
            }
        }
    }



    public static void main(String[] args) {

        DeadLock deadLock = new DeadLock();

        MyThread[] myThreads = new MyThread[2];
        for(MyThread thread:myThreads) {
            thread = new MyThread(deadLock);
            new Thread(thread).start();
        }
    }

}

class MyThread implements Runnable {

    DeadLock deadLock;

    public MyThread(DeadLock deadLock) {
        this.deadLock = deadLock;
    }

    @Override
    public void run() {
        for(;;) {
            deadLock.method1();
            deadLock.method2();
        }
    }
}

