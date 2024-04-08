package dev.mritunjay.multithreading.HelloPrinter;

public class HelloWorldPrinter implements Runnable{

    private void doSomething(){
        System.out.println("Do something");
    }

    public void run(){
        System.out.println("Hello world " + Thread.currentThread().getName());
        doSomething();
    }
}
