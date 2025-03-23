package uz.handsOnMiniProject;

import uz.handsOnMiniProject.service.ThreadService;
import uz.handsOnMiniProject.service.UserService;
import uz.handsOnMiniProject.threads.CustomUncaughtExceptionHandler;
import uz.handsOnMiniProject.threads.LoggerThread;


import static uz.handsOnMiniProject.utils.Util.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        CustomUncaughtExceptionHandler customUncaughtExceptionHandler = new CustomUncaughtExceptionHandler();
        customUncaughtExceptionHandler.startErrorCounterDaemonThread();
        Thread.setDefaultUncaughtExceptionHandler(customUncaughtExceptionHandler);

        ThreadService threadService = new ThreadService();
        UserService userService = new UserService();

        while (true){
            System.out.println("""
                1. Yangi Thread yaratish - Exception yaratish uchun ishlatiladi
                2. User service ga o`tish
                3. Exit
                """ );
            switch (scanner.nextInt()){
                case  1 -> {
                    threadService.creatingNewThread();
                }
                case  2 -> {
                    userService.service();
                }
                case  3 -> {
                    return;
                }
                default -> {
                    System.out.println("Invalid command..");
                }

            }
        }




        // Umumiy error lar chiqib turishi kerak har 10s

        //******************************
        // Nechta user site da bor ekanligi chiqib turishi kerak har 6s
        // username neca marta takrorlanishga urunildi
        // thread exception alohida file ga saqlanishi kk

    }

}
