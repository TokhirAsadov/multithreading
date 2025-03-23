package uz.volatileVariable;

public class Main {

    private volatile int counter = 0;

    public void increment() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }

    public static void main(String[] arg) throws InterruptedException {
        Main main = new Main();

        Runnable runnable = () ->{
            for (int i = 0; i < 10_000; i++) {
                main.increment();
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

//        Thread thread1 = new Thread(myRunnable);
//        Thread thread2 = new Thread(myRunnable);

        thread1.start();
        thread2.start();

        System.out.println("counter: "+main.getCounter());

    }

}

class MyRunnable implements Runnable {

    private volatile boolean active;

    @Override
    public void run() {
        active = true;
        while (active){
        }
        System.out.println("================ Thread finished tugadi==============");
    }

    public void stop(){
        active=false;
    }
}
