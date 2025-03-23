package uz.javatuz;

public class UncaughtExceptionThread implements Runnable{
    @Override
    public void run() {

        throw new RuntimeException("Exception in thread");


    }
}
