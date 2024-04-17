package dev.mritunjay.multithreading.AdderSubtractorSyncMethod;

public class Value {

    int value = 0;

    public synchronized void incrementBy(int num){
        this.value += num;
    }

    public synchronized void decrementBy(int num){
        this.value -=num;
    }

    public int getValue(){
        return this.value;
    }
}
