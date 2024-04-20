package dev.mritunjay.multithreading.ProdConsSemaphore;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable{

    private Store store;
    private Semaphore semaForProducer;
    private Semaphore semaForConsumer;

    public Producer(Store store , Semaphore semaForProducer , Semaphore semaForConsumer) {
        this.store = store;
        this.semaForProducer = semaForProducer;
        this.semaForConsumer = semaForConsumer;
    }

    @Override
    public void run() {
        while(true){
            try {
                semaForProducer.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
                    store.addItems();
                    semaForConsumer.release();
            }

        }
    }
