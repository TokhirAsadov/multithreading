package uz.lockHomework;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockHomeworkMain {

    private static final int MAX_VALUE = 5;
    private final Queue<Integer> queue = new LinkedList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public void producing(int item) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == MAX_VALUE) { // savat to`lib qolsa kutiwi uchun
                System.out.println("Navbat to‘la! Ishlab chiqaruvchi kutmoqda...");
                notFull.await(); // Navbat bo‘shamaguncha kutadi
            }
            queue.add(item);
            System.out.println("Ishlab chiqarildi: " + item);
            notEmpty.signal(); // Iste'molchiga xabar berish
        } finally {
            lock.unlock();
        }
    }

    public int consuming() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) { // maxsulot tayyor bulishini kutamiz - savat bush bulmasligi kerak
                System.out.println("Navbat bo‘sh! Iste'molchi kutmoqda...");
                notEmpty.await(); // Navbat to‘lishini kutadi
            }
            int item = queue.poll();
            System.out.println("Iste'mol qilindi: " + item);
            notFull.signal(); // Ishlab chiqaruvchini uyg‘otish
            return item;
        } finally {
            lock.unlock();
        }
    }



    public static void main(String[] args){
        LockHomeworkMain lockHomeworkMain = new LockHomeworkMain();

        // Ishlab chiqaruvchi (Producer)
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    lockHomeworkMain.producing(i);
                    Thread.sleep(500); // Ishlab chiqarish jarayoni
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Iste'molchi (Consumer)
        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    lockHomeworkMain.consuming();
                    Thread.sleep(1000); // Iste'mol qilish jarayoni
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
