package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("You can't divide by zero!");
        }
        return a / b;
    }

    /**
     * This main can throw an ArithmeticException!!!
     *
     * @param args
     */

    public static void main(String[] args) {

        FirstChallenge firstChallenge = new FirstChallenge();

        //try - w nawiasie tylko argumenty, które dotyczą odczytywania pliku
        try {
            double result = firstChallenge.divide(3, 0);
            System.out.println(result);

        } catch (ArithmeticException a) {
            System.out.println("Ups! Error:" + a);

        } finally {
            System.out.println("The program has finished.");
        }


    }
}
