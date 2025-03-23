package uz.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinExample {
    public static void main(String[] args) {
//        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
//        forkJoinPool.execute();

        int size = 500_000_000;
        double[] arr = new double[size];

        for (int i = 0; i < size; i++) {
            arr[i] = Math.random();
        }

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        long start = System.currentTimeMillis();
        int invoke = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i]>0.4) invoke++;
        }
//        CustomRecursiveTask customRecursiveTask = new CustomRecursiveTask(arr,0, size);
//        Integer invoke = forkJoinPool.invoke(customRecursiveTask);
        long end = System.currentTimeMillis();
        System.out.println(invoke+" -- "+(end-start)+"ms");

        // arr[i] > 0.4


    }
}
