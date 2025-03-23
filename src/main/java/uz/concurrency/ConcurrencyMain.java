package uz.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrencyMain {
    private int counter = 0;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    // 3-usul > lock, synchronized
//    private AtomicInteger counter = new AtomicInteger(0);
//
//    public void increment(){
//        counter.incrementAndGet();
//    }

//    private final Lock lock = new ReentrantLock();


    // 2.2 usul
//    public void increment() {
//        synchronized (this) {
//            counter++;
//        }
//    }

    // 2.1 usul
//    public synchronized void increment() {
//        counter++;
//    }

    // 1-usul
//    private final Lock lock = new ReentrantLock();
//
    public void increment() {
        lock.lock();
        counter++;
        lock.unlock();
    }

//    public void increment(){
//        counter++;
//    }

    public int getCounter(){
        return counter;
    }

//    public AtomicInteger getCounter(){
//        return counter;
//    }

    public static void main(String[] args) throws InterruptedException {

        ConcurrencyMain example = new ConcurrencyMain();

//        Runnable runnable = () -> {
//            for (int i=0; i<10_000;i++){
//                example.increment();
//            }
//        };
//
//        Thread t1 = new Thread(() -> {
//            for (int i=0; i<10_000;i++){
//                example.increment();
//            }
//        });
//        Thread t2 = new Thread(() -> {
//            for (int i=0; i<10_000;i++){
//                example.increment();
//            }
//        });
//
//        t1.start();
//        t2.start();
//
//        t1.join();
//        t2.join();
//
//        System.out.println("counter -> "+example.getCounter());


//        AtomicInteger i = new AtomicInteger(5);
//        System.out.println(i.get());
//        System.out.println(i.incrementAndGet());
//        System.out.println(i.getAndIncrement());
//        System.out.println(i.decrementAndGet());
//        System.out.println(i.getAndDecrement());
//        System.out.println(i.get());

//        if (i.get()==5){
//            i.set(8);
//        }
//
//        i.compareAndSet(10,0);
//        System.out.println(i.get());
//
//
//
//        i.compareAndSet(i.get(),40);
//        System.out.println(i.get());
//
//        AtomicReference<String> name = new AtomicReference<>("Hello");
//        System.out.println(name.get());
//
//        name.compareAndSet("Hello","o`zgar");
//        System.out.println(name.get());




    }
}
