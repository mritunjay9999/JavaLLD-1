package dev.mritunjay.multithreading.NumberPrinterThreadPooling;

import dev.mritunjay.multithreading.HelloPrinter.HelloWorldPrinter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        int a = 10;

        HelloWorldPrinter helloWorldPrinter = new HelloWorldPrinter();

        ExecutorService e1 = Executors.newFixedThreadPool(10);
        for(int i=1;i<=100;i++)
        {
            NumberPrinterThreadPool n = new NumberPrinterThreadPool(i);
            e1.execute(n);
//            Thread t = new Thread(n);
//            t.start();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
