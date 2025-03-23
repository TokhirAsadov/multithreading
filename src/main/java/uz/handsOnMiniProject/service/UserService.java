package uz.handsOnMiniProject.service;

import uz.handsOnMiniProject.entity.User;

import static uz.handsOnMiniProject.utils.Util.*;
import static uz.handsOnMiniProject.utils.DB.*;

public class UserService {

    public void service() {
        while (true){
            System.out.println("""
                1. User Yaratish
                2. Jami userlar soni
                3. Exit
                """ );
            switch (scanner.nextInt()){
                case  1 -> {
                    createUser();
                }
                case  2 -> {
                    countOfUsers();
                }
                case  3 -> {
                    return;
                }
                default -> {
                    System.out.println("Invalid command..");
                }

            }
        }
    }

    private void countOfUsers() {
        System.out.println("Dasturimizda "+users.size()+" ta user bor.");
    }

    private void createUser() {
        System.out.println("name ni kiriting");
        String name = strScanner.nextLine();

        while (true) {
            System.out.println("username ni kiriting");
            String username = strScanner.nextLine();

            if (users.add(new User(name, username))) {
                System.out.println("🎉 Urraaaaaa");
                return;
            } else {
                System.err.println("😢 Bunday username ishlatilgan..");
            }
        }
    }
}
