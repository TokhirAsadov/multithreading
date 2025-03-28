package uz.finalExamExample;

import uz.finalExamExample.services.CardService;
import uz.finalExamExample.services.UserService;

import static uz.finalExamExample.services.SerAndDeserializationService.makingDatabase;
import static uz.finalExamExample.util.Utils.scanner;

public class OnlineShopExample {
    public static void main(String[] args) {
        UserService userService = new UserService();
        CardService cardService = new CardService();
        makingDatabase();
        while (true){
            String mainMenu = """
                    1. Sign Up (register)
                    2. Sign In (login)
                    3. All users count
                    4. Users Ids
                    5. User details by id
                    6. Create Card
                    7. Cards Ids
                    8. Card details by id
                    
                    0. Exit
                    """;
            System.out.println(mainMenu);
            switch (scanner.nextInt()){
                case 1-> {
                    userService.signUp();
                }
                case 2-> {
//                    userService.signIp();
                }
                case 3-> {
                    userService.getAllUserCount();
                }
                case 4-> {
                    userService.getAllUsersIds();
                }
                case 5-> {
                    userService.getUserDetails();
                }
                case 6-> {
                    cardService.createCard();
                }
                case 7-> {
                    cardService.getAllCardsIds();
                }
                case 8-> {
                    cardService.getCardDetailsById();
                }
                case 0-> {
                    System.out.println("Bye bye..");
                    return;
                }
                default -> {
                    break;
                }
            }
        }
    }
}
