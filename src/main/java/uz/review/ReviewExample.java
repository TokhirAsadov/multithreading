package uz.review;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class ReviewExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<String> completableFuture = new CompletableFuture<>();
//        completableFuture.complete("Hello, World!");
//        System.out.println(completableFuture.get());

//        CompletableFuture<String> completableFuture =
//                CompletableFuture.supplyAsync(()->"supplyAsync javob qaytaradi");
//        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
//            System.out.println("runAsync ishga tushdi");
//        });


        //  CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> "G52");
        //        CompletableFuture<String> completableFuture2 = completableFuture1.thenApply(s -> s + " Java gruhi");
        //        CompletableFuture<Void> completableFuture3 = completableFuture2.thenAccept(s -> {
        //            System.out.println(s);
        //            System.out.println("End");
        //        });

//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "G52",executorService)
//                .thenApply(s -> {
//                    if (true)throw new RuntimeException("Error");
//                    return s + " Java gruhi";
//                })
//                        .handle((s, throwable) -> {
//                            if (throwable != null) {
//                                System.out.println("Error: " + throwable.getMessage());
//                                return "Error";
//                            }
//                            if (s != null) return s+" handle bilan ushlandi";
//                            return "xatolik bor";
//                        });
//                .exceptionally(throwable -> {
//                    System.out.println("Error: " + throwable.getMessage());
//                    return "atomic bor";
//                });
//        System.out.println(completableFuture.get());

        m1();
        m2();
        for (int i = 0; i < 10; i++) {
            System.out.println("Main thread ishlayapdi "+i);
        }

    }

    public static void m1() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        CompletableFuture<Boolean> userChecking = CompletableFuture.supplyAsync(() -> {
            System.out.println("user checking is running... "+Thread.currentThread());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("user checking is finished...");
            return true;
        },executorService);
        CompletableFuture<Boolean> userSaving = CompletableFuture.supplyAsync(() -> {
            System.out.println("user saving is running... "+Thread.currentThread());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("user saving is finished...");
            return true;
        },executorService);
        CompletableFuture<Boolean> userSendingEmail = CompletableFuture.supplyAsync(() -> {
            System.out.println("user sending email is running... "+Thread.currentThread());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("user sending email is finished...");
            return true;
        },executorService);
    }

    public static void m2() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CompletableFuture<Void> completableFuture
                = CompletableFuture.supplyAsync(() -> "siz muvaffaqiyatli ro`yxatdan o`tdingiz "+ Thread.currentThread(),executorService)
                .thenAccept(s -> System.out.println(s));
    }
}
