package by.lesson16;

public class Main {
    String variable;
    public static void main(String[] args) {
        System.out.println("Hello World!");
        B b = new B();
        Main a=new Main();

    }

    public Main(){
        printVariable();
    }

    protected void printVariable(){
        variable = "variable is initialized in Main Class";
    }




}

