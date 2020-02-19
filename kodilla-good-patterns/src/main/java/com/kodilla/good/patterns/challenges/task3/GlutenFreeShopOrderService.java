package com.kodilla.good.patterns.challenges.task3;

import java.time.LocalDate;

public class GlutenFreeShopOrderService implements OrderService {
    @Override
    public boolean order(User user, Order order, LocalDate time) {
        return true;
    }
}
