package uz.handsOnMiniProject.threads;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CustomUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{

    private static int counter = 0;
    private final Lock lock = new ReentrantLock();
//    private final Condition condition = lock.newCondition();

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.err.println("Uncaught Exception is occurred in "+t.getName()+". Error: "+e.getMessage());
        writeErrorInFile(t,e);
        counter++;
    }

    private void writeErrorInFile(Thread t, Throwable e) {
        try {
            // file yaratib beradi
            FileWriter fw = new FileWriter("error.log",true);
            // filega yozish imkonini beradi.
            PrintWriter pw = new PrintWriter(fw);

            pw.println("Thread: "+t.getName());
            pw.println("Error: "+e.getMessage());
            e.printStackTrace(pw);
            pw.println("------------------------------------------------------");
            pw.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void startErrorCounterDaemonThread(){
        Thread thread = new Thread(()->{
            try {
                while (true) {
                    System.out.println("10 sekund ichida "+counter+" ta exception sodir bo`ldi.");
                    Thread.sleep(10000);
                }
            } catch (InterruptedException e) {
                System.err.println("Daemon thread is interrupted.");
            }
            System.out.println("Daemon thread ishlashni tuxtatdi,");
        });

        thread.setDaemon(true);
        thread.start();
    }

}
