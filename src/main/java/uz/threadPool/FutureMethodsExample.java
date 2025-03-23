package uz.threadPool;

import java.util.concurrent.*;

public class FutureMethodsExample {
    public static void main(String[] args) {
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(coreCount);

        Callable<String> callable = () -> {
            System.out.println("Callable is running....");
            Thread.sleep(2000);
            return "Hello Java";
        };

        Future<String> future = executorService.submit(callable);

        try {
//            System.out.println(future.get());
//            System.out.println(future.get(1,TimeUnit.SECONDS));
            Thread.sleep(1000);
            if (future.isDone()){
                System.out.println("Hammasi joyida. Callable uz vaqtida ishladi");
            } else {
                System.out.println("Callable is cancelling....");
                future.cancel(true);
            }
            System.out.println(future.isCancelled());
            System.out.println(future.isDone());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();

    }
}
