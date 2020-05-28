package com.kodilla.patterns2.decorator.taxiportal;

import java.math.BigDecimal;

// reprezentuje podstawowe zamówienie taksówki; delegat
public class BasicTaxiOrder implements TaxiOrder {
    @Override
    public BigDecimal getCost() {
        return new BigDecimal(5.00); // zwraca info o podstawowym koszcie przejazdu
        // opłata za zamówienie taksówki
    }

    @Override
    public String getDescription() {
        return "Drive a course"; // zwraca podstawowy opis usługi
    }
}
