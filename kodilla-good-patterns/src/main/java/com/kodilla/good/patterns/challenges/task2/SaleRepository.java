package com.kodilla.good.patterns.challenges.task2;

import java.time.LocalDate;

public interface SaleRepository {

    boolean createSale(User user, Item item, LocalDate time);
}
//interfejs do bazy danych