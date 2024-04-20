package dev.mritunjay.multithreading.ProdConsSemaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

            ExecutorService es = Executors.newCachedThreadPool();
            Store store = new Store(5);
            Semaphore semaForProducer = new Semaphore(5);
            Semaphore semaForConsumer = new Semaphore(0);

            for(int i=1;i<=8;i++){
                es.execute(new Producer(store , semaForProducer , semaForConsumer));
            }

            for(int i=1;i<=20;i++){
                es.execute(new Consumer(store , semaForProducer , semaForConsumer));
            }
            System.out.println("WAIT");


    }
}
