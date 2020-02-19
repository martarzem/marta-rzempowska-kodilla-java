package com.kodilla.good.patterns.challenges.task4;

public class Application {

    public static void main (String[] args) {

        FlightRepository flightRepository = new FlightRepository();

        FlightFinder flightFinder = new FlightFinder(flightRepository.create());

        System.out.println(flightFinder.findFlightFrom("Warsaw"));

        System.out.println(flightFinder.findFlightTo("Radom"));

        System.out.println(flightFinder.findFlightWithChange("Wroclaw"));


    }
}
