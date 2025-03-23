package uz.project;

public class LoggerThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Logger thread is running.");
        try {
            Thread.sleep(2000);
            throw new RuntimeException("Logger thread error!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
