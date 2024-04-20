package dev.mritunjay.multithreading.ProdConsSemaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Store {

    private int maxSize;
    private ConcurrentLinkedDeque<Object> items;

    public Store(int maxSize) {
        this.maxSize = maxSize;
        this.items = new ConcurrentLinkedDeque<>();
    }

//    public List<Objects> getItems(){
//        return this.items;
//    }

    public int getMaxSize(){
        return this.maxSize;
    }

    public void addItems(){
        this.items.add(new Object());
        System.out.println("Items Produced. The size of store has reached : " + items.size());
    }

    public void removeItems(){
        this.items.remove();
        System.out.println("Items Consumed. The size of store has reduced to : " + items.size());
    }
}
