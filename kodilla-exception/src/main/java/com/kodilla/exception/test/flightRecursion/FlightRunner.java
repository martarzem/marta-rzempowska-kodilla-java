package com.kodilla.exception.test.flightRecursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightRunner {

    public static void main(String[] args) {

        Map<String, List<String>> connections = new HashMap<>();
        connections.put("Warsaw", Arrays.asList("Prague"));
        connections.put("Prague", Arrays.asList("Moscow"));
        connections.put("Moscow", Arrays.asList("Paris"));

        FlightFinder flightFinder = new FlightFinder();

        //direct flight
        try {
            flightFinder.findFlight("Warsaw", "Prague", connections);
            System.out.println("A direct flight is available.");

        } catch (RouteNotFoundException r) {
            System.out.println("Sorry! The flight is not in the base.");

        } finally {
            System.out.println("Your search results are above!\n");
        }

        //indirect flight
        try {
            flightFinder.findFlight("Warsaw", "Paris", connections);
            System.out.println("An indirect flight is available.");

        } catch (RouteNotFoundException r) {
            System.out.println("Sorry! The flight is not in the base.");

        } finally {
            System.out.println("Your search results are above!\n");
        }

        //the connection is impossible
        try {
            flightFinder.findFlight("Warsaw", "Madrid", connections);
            System.out.println("An indirect flight is available.");

        } catch (RouteNotFoundException r) {
            System.out.println("The flight is unavailable.");

        } finally {
            System.out.println("Your search results are above!\n");
        }
    }
}

