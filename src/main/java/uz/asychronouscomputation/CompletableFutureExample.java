package uz.asychronouscomputation;

import java.util.concurrent.*;
import java.util.function.Supplier;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //m1

//        CompletableFuture<String> completableFuture = new CompletableFuture<>();
//        completableFuture.complete("Hello Java!");
//        System.out.println(completableFuture.get());



        //supplyAsync()
//        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
//            @Override
//            public String get() {
//                System.out.println("Supplier is running...");
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                return "Response from supplier";
//            }
//        });


        // runAsync()
//        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
//            System.out.println("Runnable is running...");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("Runnable is finished...");
//        });
//
//        System.out.println(completableFuture.get());

        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()-> System.out.println("Runnable is running..."));








        Thread.sleep(500);
        System.out.println("main thread is done...");
//        System.out.println(completableFuture.get());

//        System.out.println(completableFuture.get());

    }

    public static void m1() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future<String> future = executorService.submit(() -> {
            System.out.println("Runnable is running...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Runnable is finished...");

            return "Response from Callable";
        });
        executorService.shutdown();
        System.out.println(future.get());
        System.out.println("main thread ishlayapdi...");
    }
}
