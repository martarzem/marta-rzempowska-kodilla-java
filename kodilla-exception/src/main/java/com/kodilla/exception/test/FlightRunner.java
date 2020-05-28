package com.kodilla.exception.test;

public class FlightRunner {

    public static void main(String[] args) {

        // Warsaw - true, Beijing - true
        Flight beijing = new Flight("Warsaw", "Beijing");
        FlightFinder beijingFind = new FlightFinder();

        try {
            beijingFind.findFlight(beijing);
        } catch (RouteNotFoundException r) {
            System.out.println("Sorry! The flight is not in the base.");
        } finally {
            System.out.println("Your search results are above!");
        }

        //Wroclaw - false, Warsaw - true
        Flight warsaw = new Flight("Wroclaw", "Warsaw");
        FlightFinder warsawFind = new FlightFinder();

        try {
            warsawFind.findFlight(warsaw);
        } catch (RouteNotFoundException r) {
            System.out.println("Sorry! The flight is not in the base.");
        } finally {
            System.out.println("Your search results are above!");
        }

        // there isn't Prague airport
        Flight prague = new Flight("Warsaw", "Prague");
        FlightFinder pragueFind = new FlightFinder();

        try {
            pragueFind.findFlight(prague);
        } catch (RouteNotFoundException r) {
            System.out.println("Sorry! The flight is not in the base.");
        } finally {
            System.out.println("Your search results are above!");
        }
    }
}
