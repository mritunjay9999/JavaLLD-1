package dev.mritunjay.multithreading.NumberPrinterThreadPooling;

public class NumberPrinterThreadPool implements Runnable {
    private int noToPrint;
    NumberPrinterThreadPool(int noToPrint)
    {
        this.noToPrint = noToPrint;
    }
    @Override
    public void run() {
        System.out.println("Printing Number : " + noToPrint);
    }
}
