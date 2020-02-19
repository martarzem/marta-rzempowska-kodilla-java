package com.kodilla.good.patterns.challenges.task2;

public class MailService implements InformationService {
    @Override
    public void inform(User user, Item item) {
        System.out.println("Hello " + user.getUserName() + "!");
        System.out.println("Thank you for using our services.");
        System.out.println("You just ordered " + item.getItemName() +
                ", which costs " + item.getItemPrice() + " $.");
    }
}
//metoda wysyłająca maila do klienta z informacją o kupnie