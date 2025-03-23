package uz.project;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CustomUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.err.println("Uncaught exception in thread: " + t.getName()+": "+e.getMessage());
        writeErrorToFile(t,e);
    }

    private void writeErrorToFile(Thread t, Throwable e) {
        try(FileWriter fw = new FileWriter("error.log");
            PrintWriter pw = new PrintWriter(fw)){
            pw.println("Thread: "+t.getName());
            pw.println("Exception: "+ e.getMessage());
            e.printStackTrace(pw);
            pw.println("---------------------------------------");
        } catch (IOException ex) {
            System.err.println("Failed to write error to log file: "+ex.getMessage());
        }
    }


}
