package com.kodilla.good.patterns.challenges.task2;

import java.time.LocalDate;

public class SaleRequestRetriever {

    public SaleRequest retrieve() {

        User user = new User("Peter", "Big");
        Item item = new Item("Iron", 100);
        LocalDate time = LocalDate.now();

        return new SaleRequest(user, item, time);
    }
}
//uzyskuje informacje o żądaniu kupna