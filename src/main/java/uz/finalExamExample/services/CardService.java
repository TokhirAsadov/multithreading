package uz.finalExamExample.services;

import uz.finalExamExample.entity.Card;
import uz.finalExamExample.entity.User;

import java.io.File;
import java.util.UUID;

import static uz.finalExamExample.database.DB.cards;
import static uz.finalExamExample.database.DB.users;
import static uz.finalExamExample.services.SerAndDeserializationService.serialized;
import static uz.finalExamExample.util.Utils.scanner;
import static uz.finalExamExample.util.Utils.strScanner;

public class CardService {

    public void createCard() {
        String cardNumber;

        while (true) {
            boolean bool = false;
            System.out.println("Enter card number: ");
            cardNumber = strScanner.nextLine();
            for (Card card : cards) {
                if (card.getCardNumber().equals(cardNumber)) {
                    System.err.println("card number "+cardNumber+" already exists. Please, enter another card number");
                    bool=true;
                }
            }
            if (!bool) {
                break;
            }
        }
        System.out.println("Enter card balance: ");
        Double balance= scanner.nextDouble();

        User user = null;
        while (true) {
            boolean bool = false;
            System.out.println("Enter your username: ");
            String username = strScanner.nextLine();
            for (User user1 : users) {
                if (user1.getUsername().equals(username)) {
                    user = user1;
                    bool=true;
                }
            }
            if (bool) {
                break;
            } else {
                System.err.println("username "+username+" does not exist. Please, enter available username");
            }
        }



        Card card = new Card(UUID.randomUUID(),cardNumber,balance,user);
        serialized(card,new File("final/cards.txt"));
        cards.add(card);
    }

    public void getAllCardsIds() {
        for (Card card : cards) {
            System.out.println(card.getId());
        }
    }

    public void getCardDetailsById() {
        String cardId = strScanner.nextLine();
        for (Card card : cards) {
            if (card.getId().equals(UUID.fromString(cardId))){
                System.out.println(card);
                break;
            }
        }
    }
}
