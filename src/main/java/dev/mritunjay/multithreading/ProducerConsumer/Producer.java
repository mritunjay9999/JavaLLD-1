package dev.mritunjay.multithreading.ProducerConsumer;

public class Producer implements Runnable{

    private Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while(true){
            synchronized (store){
                if(this.store.getItems().size() < store.getMaxSize()){      // when sync not used then ex- 5 threads can enter this line
                    // and execute the addItems(), (bcz for all size < maxSize at the same time)
                    // which would make the size of store >5 i.e. not allowed. Therefore, we use sync keyword on store object.
                    store.addItems();
                }
            }

        }
    }
}
