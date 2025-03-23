package uz.javatuz;

public class MyRunnableThreadForNaming implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+" ishga tushdi");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
//                throw new RuntimeException(e);
            }
        }
    }
}
