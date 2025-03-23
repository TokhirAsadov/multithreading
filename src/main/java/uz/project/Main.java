package uz.project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Thread loggerThread = new Thread(new LoggerThread());
        Thread schedulerThread = new Thread(new SchedulerThread());


        Thread.setDefaultUncaughtExceptionHandler(new CustomUncaughtExceptionHandler());
        // Start threads
        loggerThread.start();
        schedulerThread.start();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit){
            System.out.println("Choose an option:");
            System.out.println("1. Perform Task 1");
            System.out.println("2. Perform Task 2");
            System.out.println("3. Simulate Error");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Task 1 is performed.");
                    break;
                case 2:
                    System.out.println("Task 2 is performed.");
                    break;
                case 3:
                    // Simulate an error in the logger thread
                    throw new RuntimeException("Simulated error in the main thread!");
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }

        scanner.close();
        System.out.println("Exiting the program...");
    }
}
