package uz.synchronizationWithSynchronized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    private int counter1 = 0;
    private int counter2 = 0;
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void incrementCounter1() {

        // this
        // object lock
        // Main.class

        synchronized (Main.class) {
            counter1++;
            try {
                Thread.sleep(1); // Simulyatsiya uchun kechikish
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void incrementCounter2() {
        synchronized (Main.class) { // Xuddi shu qulf
            counter2++;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getCounter1() {
        return counter1;
    }

    public int getCounter2() {
        return counter2;
    }




    public static void main(String[] arg) throws InterruptedException {

        Main main = new Main();
        Main main2 = new Main();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                main.incrementCounter1();
                // counter 1
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                main2.incrementCounter2();
                // counter 2
            }
        }, "Thread-2");


        long start = System.currentTimeMillis();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long end = System.currentTimeMillis();

        System.out.println("Counter1 (this): " + main.getCounter1());
        System.out.println("Counter2 (this): " + main2.getCounter2());
        System.out.println("Sarflangan vaqt: "+(end-start)+" ms.");




    }
}
