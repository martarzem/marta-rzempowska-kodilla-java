package com.kodilla.exception.test;

public class ExceptionHandling {

    public void main (String[] args) {

        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            String result = secondChallenge.probablyIWillThrowException(3.5, 2.5);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Error! Try with another numbers.");
        } finally {
            System.out.println("Program has finished.");
        }
    }
}
