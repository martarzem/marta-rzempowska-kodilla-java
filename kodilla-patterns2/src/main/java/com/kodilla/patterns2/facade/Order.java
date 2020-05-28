package com.kodilla.patterns2.facade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//reprezentuje zamówienie
public class Order {
    private final List<Item> items = new ArrayList<>(); //lista rzeczy
    private final Long orderId; //identyfikator zamówienia
    private final Long userId; //identyfikator użytkownika
    private boolean isPaid = false; //czy zamówienie zostało opłacone
    private boolean isVerified = false; //czy zamówienie zostało zweryfikowane przez system i może być ostatecznie zatwierdzone
    private boolean isSubmitted = false; //czy zamówienie zostało ostatecznie zatwierdzone
    private ProductService productService; //referancja do komponentu sprawdzającego ceny produktów

    public Order(Long orderId, Long userId, ProductService productService) {
        this.orderId = orderId;
        this.userId = userId;
        this.productService = productService;
    }

    //oblicza wartość zamówienia
    public BigDecimal calculateValue() {
        BigDecimal sum = BigDecimal.ZERO;
        for (Item item : items) {
            sum = sum.add(productService.getPrice(item.getProductId()))
                    .multiply(new BigDecimal(item.getQty()));
        }
        return sum;
    }

    public List<Item> getItems() {
        return items;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public boolean isSubmitted() {
        return isSubmitted;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public void setSubmitted(boolean submitted) {
        isSubmitted = submitted;
    }
}
