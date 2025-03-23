package uz.project;

public class SchedulerThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Scheduler thread is running.");
        try {
            Thread.sleep(3000);
            throw new RuntimeException("Scheduler thread error!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
