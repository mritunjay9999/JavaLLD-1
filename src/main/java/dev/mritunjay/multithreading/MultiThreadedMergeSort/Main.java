package dev.mritunjay.multithreading.MultiThreadedMergeSort;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws Exception {

        List<Integer> arrayToSort = List.of(8 , 1 , 2 , 9 , 6 , 3 , 7 , 5 , 4);
//        creating a single newCachedThreadPool so that single thread pool is created (with multiple threads) rather than multiple pools (as in call() method)
        ExecutorService es = Executors.newCachedThreadPool();

//        passing the object of ExecutorService in constructor
        Sorter sorter = new Sorter(arrayToSort , es);

//        Unlike in Runnable where we dont call run() directly , here we call call()
        List<Integer> sortedArray = sorter.call();

        for(int i=0;i<sortedArray.size();i++)
        {
            System.out.println(sortedArray.get(i));
        }
    }
}
