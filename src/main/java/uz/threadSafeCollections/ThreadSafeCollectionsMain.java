package uz.threadSafeCollections;

import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class ThreadSafeCollectionsMain {

    public static void main(String[] args) throws InterruptedException {

//        HashSet<Integer> integers = new HashSet<>();
        // 1 usul
//        var integers = ConcurrentHashMap.<Integer>newKeySet();

        // 2.usul
        var integers = Collections.synchronizedSet(new HashSet<>());

        new Thread(()->{
            try {
                for (int i = 1; i <= 1000; i++) {
                    integers.add(i);
                    Thread.sleep(1);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(()->{
            try {
                for (int i = 1001; i <= 2000; i++) {
                    integers.add(i);
                    Thread.sleep(1);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();


        Thread.sleep(2000);
        System.out.println("Set size : "+integers.size());

    }
}
