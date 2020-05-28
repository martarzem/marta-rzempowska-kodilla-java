package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {

    @Test
    public void testAdd() {

        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);

        double result = calculator.add(10, 10);

        Assert.assertEquals(20, result, 0);

    }

    @Test
    public void testSub() {

        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);

        double result = calculator.sub(10, 10);

        Assert.assertEquals(0, result, 0);

    }

    @Test
    public void testMul() {

        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);

        double result = calculator.mul(10, 10);

        Assert.assertEquals(100, result, 0);

    }

    @Test
    public void testDivByNumberOtherThanZero() {

        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);

        double result = calculator.div(10, 10);

        Assert.assertEquals(1, result, 0);
    }

    @Test
    public void testDivByZero() {

        try {
            ApplicationContext context =
                    new AnnotationConfigApplicationContext("com.kodilla.spring");
            Calculator calculator = context.getBean(Calculator.class);

            double result = calculator.div(10, 0);

        } catch (ArithmeticException e) {
            Assert.assertEquals("You can't divide by zero.", e.getMessage());
        }


    }

}
