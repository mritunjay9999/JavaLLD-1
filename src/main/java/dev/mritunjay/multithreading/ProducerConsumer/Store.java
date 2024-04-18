package dev.mritunjay.multithreading.ProducerConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Store {

    private int maxSize;
    private List<Objects> items;

    public Store(int maxSize) {
        this.maxSize = maxSize;
        this.items = new ArrayList<>();
    }

    public List<Objects> getItems(){
        return this.items;
    }

    public int getMaxSize(){
        return this.maxSize;
    }

    public void addItems(){
        this.items.add(null);
        System.out.println("Items Produced. The size of store has reached : " + items.size());
    }

    public void removeItems(){
        this.items.remove(items.size()-1);
        System.out.println("Items Consumed. The size of store has reduced to : " + items.size());
    }
}
