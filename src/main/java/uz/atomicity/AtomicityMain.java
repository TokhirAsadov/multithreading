package uz.atomicity;

import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicityMain {

    private int count = 0;

    public void increment() {
        count++; // Bu atomik emas!
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {


        var set1 = new HashSet<Integer>();
        var set = Collections.synchronizedSet(set1);

        Runnable runnable1 = () -> {
            try {
                for (int i = 0; i < 1000; i++)
                    set.add(i);
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable runnable2 = () -> {
            try {
                for (int i = 1000; i < 2000; i++)
                    set.add(i);
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);

        t1.start();
        t2.start();

        TimeUnit.SECONDS.sleep(2);
        System.out.println(set.size());






//        AtomicIntegerArray array = new AtomicIntegerArray(5);
//        array.addAndGet(0, 10); // 0-indeksdagi elementni 10 ga oshiradi
//
//        AtomicityMain counter = new AtomicityMain();
//        Runnable task = () -> {
//            for (int i = 0; i < 10_000; i++) {
//                counter.increment();
//            }
//        };
//
//        Thread t1 = new Thread(task);
//        Thread t2 = new Thread(task);
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
//
//        System.out.println("Natija: " + counter.getCount()); // race condition
    }

}
