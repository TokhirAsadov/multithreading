package uz.threadPool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WithoutThreadLocal {
    public static void main(String[] args) {
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(coreCount);

        Runnable runnable = () -> {
            getDate(new Date());
        };

        for (int i = 0; i < 1000; i++) {
            executorService.execute(runnable);
        }

        executorService.shutdown();
    }

    private static void getDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        String format = simpleDateFormat.format(date);
        System.out.println(format);
    }
}
