package uz.pdp.synchronization;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    private static int sotilgan_tovarlar_soni = 0;
    private static int AKSIYA_COUNT = 10;
    private static final int MAXSULOTNING_AKSIYA_NARXI = 800;
    private static final int ASIL_AKSIYA_NARXI = 1200;

    private static Object object = new Object();

    private int counter1 = 0;
    private int counter2 = 0;
//    private int counter = 0;

    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static boolean ready = false;



    public void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            synchronized (object) {
                try {
                    while (AKSIYA_COUNT != 0) {
                        AKSIYA_COUNT--;
                        sotilgan_tovarlar_soni++;
                        System.out.println(sotilgan_tovarlar_soni + " tovar aksiyada sotildi.");
                        Thread.sleep(1000);
                    }
                    object.notifyAll();//condition.signalAll()
                    notify();// condtion.signal()
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread aksiyaMonitoring = new Thread(()->{
//            lock.lock();

            synchronized (object) {
                try {
                    System.out.println("🎉AKSIYA boshlandi.....");
                    while (AKSIYA_COUNT != 0) {
                        System.out.println("kutyapman....");
                        wait(); //condition.await();
//                    condition.awaitUninterruptibly(); //---------
                    }
                    System.out.println("😒Aksiya tugadi.....");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } /*finally {
                lock.unlock();
            }*/
            }

        });

        aksiyaMonitoring.start();
        thread.start();

        aksiyaMonitoring.join();
        thread.join();



//        Thread thread1 = new Thread(()->{
//            lock.lock();
//            try {
//                System.out.println("Producer product tayyorlayapdi.....");
//                Thread.sleep(3000);
//
//                ready=true;
//                condition.signalAll();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            } finally {
//                lock.unlock();
//            }
//        });

//        Thread thread2 = new Thread(()->{
//            lock.lock();
//            try {
//                while (!ready){
//                    System.out.println("Consumer Productni kutayapdi....");
//                    condition.await();
//                }
//                System.out.println("COnsumer Productni oldi...");
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            } finally {
//                lock.unlock();
//            }
//        });

//        thread2.start();
//        thread1.start();
//
//        thread1.join();
//        thread2.join();

//        System.out.println("Counter: "+counter);



//        Main example = new Main();
//
//        Thread t1 = new Thread(() -> {
//            for (int i = 0; i < 100; i++) {
//                example.incrementCounter1();
//            }
//        }, "Thread-1");
//
//        Thread t2 = new Thread(() -> {
//            for (int i = 0; i < 100; i++) {
//                example.incrementCounter2();
//            }
//        }, "Thread-2");
//
//        long startTime = System.currentTimeMillis();
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
//        long endTime = System.currentTimeMillis();
//
//        System.out.println("Counter1 (this): " + example.getCounter1());
//        System.out.println("Counter2 (this): " + example.getCounter2());
//        System.out.println("Time taken (this): " + (endTime - startTime) + " ms");




    }
}
