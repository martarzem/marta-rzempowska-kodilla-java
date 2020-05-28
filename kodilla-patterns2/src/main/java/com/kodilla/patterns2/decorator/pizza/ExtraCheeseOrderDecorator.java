package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ExtraCheeseOrderDecorator extends AbstractPizzaOrderDecorator {
    public ExtraCheeseOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getTotalCost() {
        return super.getTotalCost().add(new BigDecimal(5));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + extra cheese";
    }
}
