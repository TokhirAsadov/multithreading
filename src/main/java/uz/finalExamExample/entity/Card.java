package uz.finalExamExample.entity;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.UUID;

public class Card implements Externalizable {
    private UUID id;
    private String cardNumber;
    private Double balance;
    private User user;

    public Card() {
    }

    public Card(UUID id, String cardNumber, Double balance, User user) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", balance=" + balance +
                ", user=" + user +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(id);
        out.writeObject(cardNumber);
        out.writeDouble(balance);
        out.writeObject(user);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        id = (UUID) in.readObject();
        cardNumber = (String) in.readObject();
        balance = in.readDouble();
        user = (User) in.readObject();
    }
}
