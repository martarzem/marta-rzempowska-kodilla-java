package com.kodilla.exception.test.flightRecursion;

import java.util.List;
import java.util.Map;

public class FlightFinder {

    public boolean findFlight(String departure, String arrival,
                              Map<String, List<String>> connections) throws RouteNotFoundException {
        if (connections.containsKey(departure)) {
            List<String> destinations = connections.get(departure);
            if (destinations.contains(arrival)) {
                return true;
            } else {
                for (String dest : destinations) {
                    if (findFlight(dest, arrival, connections)) {
                        return true;
                    }
                }
            }
        } else {
            throw new RouteNotFoundException();
        } return false;
    }
}
