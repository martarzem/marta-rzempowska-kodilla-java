package com.kodilla.good.patterns.challenges.task3;

import java.time.LocalDate;

public interface OrderService {

    boolean order(User user, Order order, LocalDate time);
}
