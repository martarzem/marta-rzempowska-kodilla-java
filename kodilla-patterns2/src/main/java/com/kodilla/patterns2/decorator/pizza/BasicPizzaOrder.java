package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class BasicPizzaOrder implements PizzaOrder {
    @Override
    public BigDecimal getTotalCost() {
        return new BigDecimal(15);
    }

    @Override
    public String getDescription() {
        return "Pizza with tomato sauce";
    }
}
