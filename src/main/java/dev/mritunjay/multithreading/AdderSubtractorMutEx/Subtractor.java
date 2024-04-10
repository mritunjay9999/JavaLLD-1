package dev.mritunjay.multithreading.AdderSubtractorMutEx;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Subtractor implements Callable<Void> {

    private Value v;
    private Lock lock;
    public Subtractor(Value v , Lock lock) {
        this.v = v;
        this.lock = lock;
    }
//    Void class is present and not return type here bcz in GENERICS only WRAPPER CLASSES ARE USED
    @Override
    public Void call() throws Exception {

        for(int i=1;i<=100;i++)
        {
            lock.lock();
            v.value -=i;
            System.out.println("Subtractor doing its work : " + i);
            lock.unlock();
        }

        return null;
    }
}
