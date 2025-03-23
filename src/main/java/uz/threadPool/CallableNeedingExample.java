package uz.threadPool;

import java.util.concurrent.*;

public class CallableNeedingExample {
    public static void main(String[] args){
        // uzcard to humo
        // sender to receiver
        // check sender is valid     // 2s    true/false -> new Thread(check sender).start();
        // check receiver is valid   // 2s    true/false -> new Thread(check receiver).start();
        // transfer

        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println(coreCount);

        ExecutorService executorService = Executors.newFixedThreadPool(coreCount);

        Callable<Boolean> checkUzcard = new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                System.out.println("Checking sender...........");
                Thread.sleep(1000);
                return true;
            }
        };
        Callable<Boolean> checkHumo = new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                System.out.println("Checking receiver...........");
                Thread.sleep(1000);
                return true;
            }
        };

        Future<Boolean> responseUzcard = executorService.submit(checkUzcard);
        Future<Boolean> responseHumo = executorService.submit(checkHumo);

        executorService.shutdown();

        try {
//            Thread.sleep(1000);

            System.out.println(responseUzcard.get());
            System.out.println(responseHumo.get());

        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
