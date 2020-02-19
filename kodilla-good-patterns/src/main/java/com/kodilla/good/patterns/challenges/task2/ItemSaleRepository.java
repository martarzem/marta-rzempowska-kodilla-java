package com.kodilla.good.patterns.challenges.task2;

import java.time.LocalDate;

public class ItemSaleRepository implements SaleRepository {
    @Override
    public boolean createSale(User user, Item item, LocalDate time) {
        return true;
    }
}
//metoda do zapisywania kupna produktu w bazie danych
