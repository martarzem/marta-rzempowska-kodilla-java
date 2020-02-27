package com.kodilla.good.patterns.challenges.task3;

import java.time.LocalDate;

public class OrderRequestRetriever {

    public OrderRequest retrieveExtraShop() {

        User userExtraShop = new User("Peter", "Big");
        Order orderExtraShop = new Order("Egg", 1,10);
        LocalDate timeExtraShop = LocalDate.now();

        return new OrderRequest(userExtraShop, orderExtraShop, timeExtraShop, OrderServiceFactory.EXTRAFOODSHOP);
    }

    public OrderRequest retrieveHealthyShop() {

        User userHealthyShop = new User("Alex", "Horse");
        Order orderHealthyShop = new Order("Butter", 10,3);
        LocalDate timeHealthyShop = LocalDate.now();

        return new OrderRequest(userHealthyShop, orderHealthyShop, timeHealthyShop, OrderServiceFactory.HEALTHYSHOP);
    }

    public OrderRequest retrieveGlutenShop() {

        User userGlutenShop = new User("Sarah", "Summer");
        Order orderGlutenShop = new Order("Bread", 15,2);
        LocalDate timeGlutenShop = LocalDate.now();

        return new OrderRequest(userGlutenShop, orderGlutenShop, timeGlutenShop, OrderServiceFactory.GLUTENFREESHOP);
    }
}
