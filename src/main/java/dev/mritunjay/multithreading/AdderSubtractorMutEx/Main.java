package dev.mritunjay.multithreading.AdderSubtractorMutEx;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        Lock is an interface and ReentrantLock is a class
        Lock lock = new ReentrantLock();
        Value v = new Value();

        Adder adder = new Adder(v , lock);
        Subtractor subtractor = new Subtractor(v , lock);

        ExecutorService es = Executors.newCachedThreadPool();
        Future<Void> adderFuture = es.submit(adder);
        Future<Void> subtractorFuture = es.submit(subtractor);

        adderFuture.get();
        subtractorFuture.get();

        System.out.println("After execution final value of thread is : " + v.value);
    }
}
