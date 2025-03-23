package uz.threadPool;

import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceMethodsWithCallableAndFuture {
    public static void main(String[] args) {
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(coreCount);

        Callable<String> c1 = () -> {
//            System.out.println("Callable 1.......");
            Thread.sleep(100);
            return "Callable1";
        };

        Callable<String> c2 = () -> {
//            System.out.println("Callable 2.......");
            Thread.sleep(100);
            return "Callable2";
        };

        Callable<String> c3 = () -> {
//            System.out.println("Callable 3.......");
            Thread.sleep(100);
            return "Callable3";
        };

//        Future<String> future1 = executorService.submit(c1);
//        Future<String> future2 = executorService.submit(c2);
//        Future<String> future3 = executorService.submit(c3);

        try {
            String futureResponse = executorService.invokeAny(List.of(c1, c2, c3));

            System.out.println(futureResponse);
//            List<Future<String>> futures = executorService.invokeAll(List.of(c1, c2, c3));
//            for (Future<String> future : futures) {
//                System.out.println(future.get());
//            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}
