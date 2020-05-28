package com.kodilla.patterns2.decorator.taxiportal;

import java.math.BigDecimal;

// interfejs będzie implementowany w zamówieniu taksówki
public interface TaxiOrder {
    BigDecimal getCost(); //łączna kwota za przejazd
    String getDescription(); // opis zamówienia umieszczany na paragonie/fakturze
}
