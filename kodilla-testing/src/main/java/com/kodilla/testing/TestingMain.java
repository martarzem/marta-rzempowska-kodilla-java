package com.kodilla.testing;

import com.kodilla.testing.calculator.SimpleCalculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args){

        //testing SimpleUser
        SimpleUser simpleUser = new SimpleUser("theForum" , "User");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        //testing Calculator
        SimpleCalculator simpleCal = new SimpleCalculator();

        int addResult = simpleCal.addition(10,5);
        int subtractResult = simpleCal.subtraction(20, 7);

        // Testing addition
        if (addResult == (10+5)) {
            System.out.println("Test OK");
        } else {
            System.out.println("Error!");
        }

        // Testing subtraction
        if (subtractResult == (20-7)) {
            System.out.println("Test OK");
        } else {
            System.out.println("Error!");
        }

        System.out.println("Tests completed");
    }
}