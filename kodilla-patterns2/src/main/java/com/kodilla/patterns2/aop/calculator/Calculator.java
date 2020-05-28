package com.kodilla.patterns2.aop.calculator;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@EnableAspectJAutoProxy
public class Calculator {
    public double add(double x, double y) {
        return x + y;
    }

    public double sub(double x, double y) {
        return x - y;
    }

    public double mul(double x, double y) {
        return x * y;
    }

    public double div(double x, double y) {
        if (y == 0) {
            throw new ArithmeticException("Divide by zero!");
        }
        return x / y;
    }

    // obliczanie silni
    public BigDecimal factorial(BigDecimal n) {
        if(n.compareTo(BigDecimal.ONE) > 0) { //czy argument jest >1, bo silnia tylko z liczb dodatnich
            return n.multiply(factorial(n.subtract(BigDecimal.ONE))); //mnożenie argumentu n przez argument-1
        } else if (n.equals(BigDecimal.ONE) || n.equals(BigDecimal.ZERO)) { //jeśli argument jest =0 lub =1
            return BigDecimal.ONE; //wtedy zwraca 1, bo 0!=1 i 1!=1
        } else {
            throw new ArithmeticException("Factorial argument is negative!"); //rzucany wyjątek dla liczb ujemnych
        }
    }
}
