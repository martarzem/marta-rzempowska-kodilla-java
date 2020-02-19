package com.kodilla.good.patterns.challenges.task4;

import java.util.Set;
import java.util.stream.Collectors;


public class FlightFinder {

    private Set<Flight> connections;

    public FlightFinder(Set<Flight> connections) {
        this.connections = connections;
    }

    public String findFlightFrom(String departure) {
        return connections.stream()
                .filter(entry -> entry.getDeparture().equals(departure))
                .map(Flight::getArrival)
                .collect(Collectors.joining(", ", "You can fly from " + departure + " to: ", "."));
    }

    public String findFlightTo(String arrival) {
        return connections.stream()
                .filter(entry -> entry.getArrival().equals(arrival))
                .map(Flight::getDeparture)
                .collect(Collectors.joining(", ", "You can fly to " + arrival + " from: ", "."));
    }

    public String findFlightWithChange(String change) {
        String airportsTo = connections.stream()
                .filter(entry -> entry.getDeparture().equals(change))
                .map(Flight::getArrival)
                .collect(Collectors.joining(", "));

        return connections.stream()
                .filter(entry -> entry.getArrival().equals(change))
                .map(Flight::getDeparture)
                .collect(Collectors.joining(", ", "You can fly via " + change + " from ", " to "
                        + airportsTo + "."));
    }
}

/*
Ta metoda to ma być tak naprawdę wyszukanie dwóch osobnych lotów - miasto pośrednie ma być
podane parametrem do metody. Czyli szukasz lotu z FROM do VIA, a potem z VIA do TO.
 */







/*
    public String findTransitAirportsFromTo(String departureAirport, String arrivalAirport) {
        String prefix;
        if (findFlightsFrom(departureAirport).contains(arrivalAirport)) {
            prefix = "You can fly directly from " + departureAirport +
                    " to " + arrivalAirport + " or via: ";
        } else {
            prefix = "You can fly from " + departureAirport +
                    " to " + arrivalAirport + " via: ";
        }
        return flightsSet.stream().
                filter(flight -> flight.getDepartureAirport().equals(departureAirport))
                .map(Flight::getArrivalAirport)
                .filter(transitAirport -> flightsSet.stream()
                        .filter(flight -> flight.getDepartureAirport().equals(transitAirport))
                        .map(Flight::getArrivalAirport)
                        .collect(Collectors.joining()).contains(arrivalAirport))
                .collect(Collectors.joining(", ", prefix, "."));
    }
}


    public List<String> findFlightTo (String arrival) {
        return connections.entrySet().stream()
                .filter(entry -> entry.getValue().contains(equals(arrival)))


                //.flatMap(entry -> entry.getValue().stream())
                //.filter(entry -> entry.equals(arrival))
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(", ", "You can fly to " + arrival + " from: ", "."));
    }



        //return connections.entrySet().stream()
                //.map(Map.Entry::getKey)


        return connections.entrySet().stream()

                .map(Map.Entry::getKey)
                .collect(Collectors.joining(", ", "You can fly to " + arrival + " from: ", "."));




    public String findFlightWithChange (String departure, String arrival) {
        connections.entrySet().stream()
                .filter(entry -> entry.getKey().equals(departure))
                .map(Map.Entry::getValue)
                .flatMap(List::stream)
                .forEach(value -> findFlightWithChange(value, arrival))
                .collect(Collectors.joining(", ", "You can fly to " + arrival + " from: ", "."));


        return;

        if (connections.containsKey(departure)) {
            List<String> destinations = connections.get(departure);
            for (String dest : destinations) {
                if (findFlightWithChange(dest, arrival)) {
                    System.out.println("You can fly to " + arrival + " from " + departure + "throught " + dest + ".");
                }
            }
        } else {
            System.out.println("The connection is not available.");
        }




    }
    */




/*
 public String findFlightTo (String arrival) {
        List<String> arrivals = connections.entrySet().stream()
                //.flatMap(entry -> entry.getValue().stream())
                .filter(entry -> entry.getValue().equals(arrival))
                .collect(Collectors.toList());
        return connections.entrySet().stream()
                .filter(entry -> arrivals.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(", ", "You can fly to " + arrival + " from: ", "."));
    }
 */

/*
wyświetla wszystkie klucze
public String findFlightTo (String arrival) {
        connections.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream())
                .filter(entry -> entry.equals(arrival));
        return connections.entrySet().stream()
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(", ", "You can fly to " + arrival + " from: ", "."));
 */