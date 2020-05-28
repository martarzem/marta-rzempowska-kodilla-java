package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PizzaOrderTest {
    private PizzaOrder pizzaOrder = new BasicPizzaOrder();

    @Test
    public void shouldGetBasicCost() {
        //When
        BigDecimal cost = pizzaOrder.getTotalCost();
        //Then
        assertEquals(new BigDecimal(15), cost);
    }

    @Test
    public void shouldGetBasicDescription() {
        //When
        String description = pizzaOrder.getDescription();
        //Then
        assertEquals("Pizza with tomato sauce", description);
    }

    @Test
    public void testPizzaWithCheeseAndChicken() {
        //Given
        pizzaOrder = new ExtraCheeseOrderDecorator(pizzaOrder);
        pizzaOrder = new ExtraChickenOrderDecorator(pizzaOrder);
        //When
        BigDecimal cost = pizzaOrder.getTotalCost();
        String description = pizzaOrder.getDescription();
        //Then
        assertEquals(new BigDecimal(27), cost);
        assertEquals("Pizza with tomato sauce + extra cheese + extra chicken", description);
    }

    @Test
    public void testPizzaWithDoubleCheeseAndChicken() {
        //Given
        pizzaOrder = new ExtraCheeseOrderDecorator(pizzaOrder);
        pizzaOrder = new ExtraCheeseOrderDecorator(pizzaOrder);
        pizzaOrder = new ExtraChickenOrderDecorator(pizzaOrder);
        //When
        BigDecimal cost = pizzaOrder.getTotalCost();
        String description = pizzaOrder.getDescription();
        //Then
        assertEquals(new BigDecimal(32), cost);
        assertEquals("Pizza with tomato sauce + extra cheese + extra cheese + extra chicken", description);
    }
}
