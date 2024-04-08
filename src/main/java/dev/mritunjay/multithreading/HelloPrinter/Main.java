package dev.mritunjay.multithreading.HelloPrinter;


public class Main {
    public static void main(String[] args) {

        int a = 10;
        int b = 20;

            HelloWorldPrinter helloWorldPrinter1 = new HelloWorldPrinter();
            Thread t = new Thread(helloWorldPrinter1);
            t.start();

        System.out.println(Thread.currentThread().getName());
    }
}
