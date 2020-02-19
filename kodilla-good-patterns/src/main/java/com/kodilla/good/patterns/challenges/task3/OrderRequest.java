package com.kodilla.good.patterns.challenges.task3;

import java.time.LocalDate;

public class OrderRequest {

    private User user;
    private Order order;
    private LocalDate time;

    public OrderRequest(User user, Order order, LocalDate time) {
        this.user = user;
        this.order = order;
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public Order getOrder() {
        return order;
    }

    public LocalDate getTime() {
        return time;
    }
}
