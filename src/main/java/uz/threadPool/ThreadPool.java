package uz.threadPool;

import java.util.*;
import java.util.concurrent.*;

// 1.ThreadPool
// 2.CallableNeedingExample  - uzcard to humo
// 3.FutureMethodsExample  - Connecting API
// 4.ExecutorServiceMethodsWithCallableAndFuture  - invokeAll/invokeAny
// 5.WithThreadLocal
// 6.WithThreadPool
// 7.ThreadLocalRandomExample

public class ThreadPool {
    public static void main(String[] args) throws InterruptedException {

        method1();

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        Runnable r1 = () -> {
            System.out.println(new Date());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

//        executorService.execute(r1);

//        for (int i = 0; i < 10; i++) {
////            executorService.schedule(r1,5,TimeUnit.SECONDS);
//            executorService.scheduleAtFixedRate(r1,5,TimeUnit.SECONDS);
//        }

//        executorService.scheduleAtFixedRate(r1,1,1,TimeUnit.SECONDS);
        executorService.scheduleWithFixedDelay(r1,1,1,TimeUnit.SECONDS);


    }

    public static void method1() throws InterruptedException {
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 100; i++) {
            executorService.execute(()-> {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Executor service item"+Thread.currentThread().getName()+" :: Active thread ishlayapdi -> "+Thread.activeCount());
            });
        }

        executorService.submit(()-> System.out.println("other tasks"));
        executorService.shutdown();

        Thread.sleep(100);
        if (!executorService.awaitTermination(500, TimeUnit.MILLISECONDS)){
            executorService.shutdownNow();
        }
        System.out.println();
//        Thread.sleep(500);
//        executorService.shutdownNow();

    }
}
