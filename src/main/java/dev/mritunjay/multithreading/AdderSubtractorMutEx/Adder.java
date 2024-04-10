package dev.mritunjay.multithreading.AdderSubtractorMutEx;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

//    Void class is present and not return type here bcz in GENERICS only WRAPPER CLASSES ARE USED
public class Adder implements Callable<Void> {

    private Value v;
    private Lock lock;

    public Adder(Value v , Lock lock) {
        this.v = v;
        this.lock = lock;
    }

    //    Void class is present and not return type here bcz in GENERICS only WRAPPER CLASSES ARE USED
    @Override
    public Void call() throws Exception {

        for(int i=1;i<=100;i++){
            lock.lock();
            this.v.value += i;
            System.out.println("Adder doing its work : " + i);
            lock.unlock();
        }
        return null;
    }
}
