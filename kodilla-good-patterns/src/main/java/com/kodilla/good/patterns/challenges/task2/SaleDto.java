package com.kodilla.good.patterns.challenges.task2;

public class SaleDto {

    private User user;
    private boolean isSold;

    public SaleDto(User user, boolean isSold) {
        this.user = user;
        this.isSold = isSold;
    }

    public User getUser() {
        return user;
    }

    public boolean isSold() {
        return isSold;
    }
}
//do zwracania 2 rzeczy z medoty
