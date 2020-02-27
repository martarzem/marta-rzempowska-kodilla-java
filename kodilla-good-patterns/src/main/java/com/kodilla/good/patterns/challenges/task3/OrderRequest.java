package com.kodilla.good.patterns.challenges.task3;

import java.time.LocalDate;

public class OrderRequest {

    private User user;
    private Order order;
    private LocalDate time;
    private String orderServiceName;

    public OrderRequest(User user, Order order, LocalDate time, String orderServiceName) {
        this.user = user;
        this.order = order;
        this.time = time;
        this.orderServiceName = orderServiceName;
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

    public String getOrderServiceName() {
        return orderServiceName;
    }
}
