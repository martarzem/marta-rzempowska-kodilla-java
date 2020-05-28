package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ExtraChickenOrderDecorator extends AbstractPizzaOrderDecorator {
    public ExtraChickenOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getTotalCost() {
        return super.getTotalCost().add(new BigDecimal(7));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + extra chicken";
    }
}
