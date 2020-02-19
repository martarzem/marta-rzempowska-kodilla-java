package com.kodilla.good.patterns.challenges.task3;

import java.time.LocalDate;

public interface OrderRepository {

    boolean createOrder(User user, Order order, LocalDate time);
}
