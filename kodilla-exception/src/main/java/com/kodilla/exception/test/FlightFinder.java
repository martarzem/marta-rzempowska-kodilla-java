package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {

    public void findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> airports = new HashMap<>();
        airports.put("Warsaw", true);
        airports.put("Wroclaw", false);
        airports.put("Beijing", true);

        if (airports.containsKey(flight.getArrivalAirport()) &&
                airports.containsKey(flight.getDepartureAirport()) &&
                airports.get(flight.getArrivalAirport()) &&
                airports.get(flight.getDepartureAirport())) {
            System.out.println("The airport is available.");
        } else {
            throw new RouteNotFoundException();
        }
    }


}
