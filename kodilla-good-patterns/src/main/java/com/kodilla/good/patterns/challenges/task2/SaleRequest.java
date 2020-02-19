package com.kodilla.good.patterns.challenges.task2;

import java.time.LocalDate;

public class SaleRequest {

    private User user;
    private Item item;
    private LocalDate time;

    public SaleRequest(User user, Item item, LocalDate time) {
        this.user = user;
        this.item = item;
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public Item getItem() {
        return item;
    }

    public LocalDate getTime() {
        return time;
    }
}
//przechowuje informacje o żądaniu kupna
