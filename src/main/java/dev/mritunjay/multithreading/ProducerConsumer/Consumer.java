package dev.mritunjay.multithreading.ProducerConsumer;

public class Consumer implements Runnable{

    private Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while(true){
            synchronized (store) {
                if (this.store.getItems().size() > 0) {
                    store.removeItems();
                }
            }
        }
    }
}
