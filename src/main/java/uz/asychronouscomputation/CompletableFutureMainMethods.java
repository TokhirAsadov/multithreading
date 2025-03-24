package uz.asychronouscomputation;

import java.util.concurrent.*;

public class CompletableFutureMainMethods {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("Main Thread: " + Thread.currentThread());
        System.out.println("Tohir : " + Thread.currentThread());
        System.out.println("22222222222222222");
        System.out.println("3333333");

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> {
                    System.out.println("1.Thread: " + Thread.currentThread());
                    return "Ali";
                },executorService)
                .thenApplyAsync(s -> {
                    System.out.println("2. Thread: " + Thread.currentThread() + " " + s);
                    return s + " Aliyev";
                },executorService)
                .thenApplyAsync(s -> {
                    System.out.println("3. Thread: " + Thread.currentThread() + " " + s);
                    return s + " . G52 da o`qiytdi";
                },executorService)
                .thenAccept(s -> System.out.println(s));

// anyOf()
//        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            return "Java";
//        });
//        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> "Python");
//
//        CompletableFuture<Void> completableFuture1 = CompletableFuture.allOf(completableFuture, cf2)
//                .thenRun(() -> System.out.println("All tasks are done!"));


//        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> "Java -- "+Thread.currentThread())
//                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " 11 --- "+Thread.currentThread()))
//                .thenApply(s -> s + " 22")
//                .thenAccept(s -> System.out.println(s + " 33"));
//        System.out.println(completableFuture.get());


//        ExecutorService executorService = Executors.newFixedThreadPool(4);
//        CompletableFuture<Void> completableFuture = CompletableFuture
//                .supplyAsync(() -> "Ali :: "+Thread.currentThread(), executorService)
//                .thenAccept(s -> System.out.println(s));
//        CompletableFuture<Void> completableFuture2 = CompletableFuture
//                .supplyAsync(() -> "Vali :: "+Thread.currentThread())
//                .thenAccept(s -> System.out.println(s));

//        ForkJoinPool forkJoinPool = new ForkJoinPool();
//        ForkJoinPool forkJoinPool2 = new ForkJoinPool(4);
//        ForkJoinPool forkJoinPool3 = ForkJoinPool.commonPool();

//        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> "Ali")
//                .thenApply(s -> s + " Aliyev")
//                .thenApply(s -> s + " . G52 da o`qiytdi")
//                .thenAccept(s -> System.out.println(s))
//                .thenApply(s -> s + ". Module 4")
//                .thenAccept(s -> System.out.println(s));

        //thenApply()
//        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->{
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    return "Hello";
//                })
//                .thenApply(s -> s + " G52");


        //thenAccept()
//        CompletableFuture<Void> completableFuture = CompletableFuture
//                .supplyAsync(()->"Hello")
//                .thenAccept(s -> System.out.println(s + " G52"));


//        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(()->{
//                    System.out.println("Supplier is running...");
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    return "Hello";
//                })
//                .thenRun(() -> System.out.println("Task bajarildi..."));


        //exceptionally
//        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()->{
//                   if (true) throw new RuntimeException("Error");
//                    return 100/5;
//                }).exceptionally(throwable -> {
//                    System.out.println("Error: "+throwable.getMessage());
//                    return -1;
//                });

        // handle()
//        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()->{
//            if (false) throw new RuntimeException("Error");
//            return 100/5;
//        }).handle((s,throwable) -> {
//            if (throwable!=null)System.out.println("Error: "+throwable.getMessage());
//            if (s!=null) return s+1;
//            return -1;
//        });

        System.out.println(completableFuture.get());
    }
}
