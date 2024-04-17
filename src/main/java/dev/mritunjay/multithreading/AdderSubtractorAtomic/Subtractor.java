package dev.mritunjay.multithreading.AdderSubtractorAtomic;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Subtractor implements Callable<Void> {

    private Value v;
    public Subtractor(Value v) {
        this.v = v;
    }
//    Void class is present and not return type here bcz in GENERICS only WRAPPER CLASSES ARE USED
    @Override
    public Void call() throws Exception {

        for(int i=1;i<=500;i++)
        {
            this.v.atomicInteger.addAndGet(-i);
        }

        return null;
    }
}
