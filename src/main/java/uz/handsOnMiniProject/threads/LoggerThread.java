package uz.handsOnMiniProject.threads;

public class LoggerThread implements Runnable{
    @Override
    public void run() {
        try{
            System.out.println("Logger thread ishlayapdi....");
            Thread.sleep(1000);
            throw new RuntimeException("Logger thread'da xatolik..");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
