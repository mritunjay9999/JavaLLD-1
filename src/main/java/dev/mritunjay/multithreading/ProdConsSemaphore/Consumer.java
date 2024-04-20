package dev.mritunjay.multithreading.ProdConsSemaphore;

import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{

    private Store store;
    private Semaphore semaForProducer;
    private Semaphore semaForConsumer;

    public Consumer(Store store , Semaphore semaForProducer , Semaphore semaForConsumer) {
        this.store = store;
        this.semaForConsumer = semaForConsumer;
        this.semaForProducer = semaForProducer;
    }

    @Override
    public void run() {
        while(true){
            try {
                semaForConsumer.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
                    store.removeItems();
                    semaForProducer.release();
            }
        }
    }
