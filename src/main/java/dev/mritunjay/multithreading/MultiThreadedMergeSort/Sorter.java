package dev.mritunjay.multithreading.MultiThreadedMergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.IntUnaryOperator;

public class Sorter implements Callable {

    private List<Integer> arrayToSort;
    private ExecutorService es;

    public Sorter(List<Integer> arrayToSort , ExecutorService es){
        this.arrayToSort = arrayToSort;
        this.es = es;
    }

    @Override
    public List<Integer> call() throws Exception {

//      base condition --> when single element is left --> return that List<Integer>
        if(arrayToSort.size() <= 1)
            return arrayToSort;


//      Now dividing the array into two halves --> left and right
        int size = arrayToSort.size();
        int mid = size/2;
        List<Integer> leftArrayToSort = new ArrayList<>();
        List<Integer> rightArrayToSort = new ArrayList<>();

        for(int i=0;i<mid;i++) {
            leftArrayToSort.add(arrayToSort.get(i));
        }

        for(int i=mid;i<size;i++){
            rightArrayToSort.add(arrayToSort.get(i));
        }


//      Further dividing the array into two parts i.e. recursive calls --> after a certain point it will result in blockade and will resume only when Future object is given
        Sorter leftArraySortingTask = new Sorter(leftArrayToSort , es);
        Sorter rightArraySortingTask = new Sorter(rightArrayToSort , es);

//        in each recursive call new thread pool gets created  --> multiple thread pools
//        ExecutorService was mentioned here in the previous code

//        ExecutorService es = Executors.newCachedThreadPool();

//        Sir gave example of Bucket and water i.e. whenever a value is submitted by es.submit() , it directly goes into Future Object
//        Otherwise , it will not move ahead of this line i.e. es.submit() line (i.e. until a value is given to Future object)

//        es.submit(" instance of class ");
        Future<List<Integer>> sortedLeftArrayFuture = es.submit(leftArraySortingTask);
        Future<List<Integer>> sortedRightArrayFuture = es.submit(rightArraySortingTask);

//        get() method is to insert value of Future object into some other variable
        List<Integer> sortedLeftArray = sortedLeftArrayFuture.get();
        List<Integer> sortedRightArray = sortedRightArrayFuture.get();

        List<Integer> finalSortedArray = new ArrayList<>();

        int i=0,j=0;

//       Merge sort logic using two pointers
        while(i<sortedLeftArray.size() && j<sortedRightArray.size()){
            if(sortedLeftArray.get(i) <= sortedRightArray.get(j))
            {
                finalSortedArray.add(sortedLeftArray.get(i));
                i++;
            }


            else
            {
                finalSortedArray.add(sortedRightArray.get(j));
                j++;
            }
        }

        while(i<sortedLeftArray.size()){
            finalSortedArray.add(sortedLeftArray.get(i));
            i++;
        }

        while (j<sortedRightArray.size()){
            finalSortedArray.add(sortedRightArray.get(j));
            j++;
        }

        return finalSortedArray;
    }
}
