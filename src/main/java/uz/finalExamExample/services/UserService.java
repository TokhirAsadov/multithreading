package uz.finalExamExample.services;

import uz.finalExamExample.entity.User;

import java.io.File;
import java.util.UUID;

import static uz.finalExamExample.services.SerAndDeserializationService.serialized;
import static uz.finalExamExample.util.Utils.*;
import static uz.finalExamExample.database.DB.users;

public class UserService {
    public void signUp() {
        System.out.println("Enter your name: ");
        String name= strScanner.nextLine();
        String username;

        while (true) {
            boolean bool = false;
            System.out.println("Enter your username: ");
            username = strScanner.nextLine();
            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    System.err.println("username "+username+" already exists. Please, enter another username");
                    bool=true;
                }
            }
            if (!bool) {
                break;
            }
        }
        System.out.println("Enter your password: ");
        String password= strScanner.nextLine();

        User user = new User(UUID.randomUUID(), name, username, password);
        serialized(user,new File("final/users.txt"));
        users.add(user);
    }

    public void getAllUserCount() {
        System.out.printf("All users' count %s.\n",users.size());
    }

    public void getAllUsersIds() {
        for (User user : users) {
            System.out.println(user.getId());
        }
    }

    public void getUserDetails() {
        String userId = strScanner.nextLine();
        for (User user : users) {
            if (user.getId().equals(UUID.fromString(userId))){
                System.out.println(user);
                break;
            }
        }
    }
}
