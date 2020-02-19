package com.kodilla.good.patterns.challenges.task3;

public class MailService implements InformationService {
    @Override
    public void inform(User user, Order order) {
        System.out.println("Hello " + user.getUserName() + "!");
        System.out.println("Thank you for using our services.");
        System.out.println("You just ordered " + order.getQuantity() +
                " x " + order.getProduct() + " for " + order.getPrice() + " $ per unit.");
    }
}
