package com.kodilla.good.patterns.challenges.task4;

import java.util.HashSet;
import java.util.Set;

public class FlightRepository {

    private Set<Flight> connections = new HashSet<>();

    public Set<Flight> create() {
        connections.add(new Flight("Warsaw", "Wroclaw"));
        connections.add(new Flight("Wroclaw", "Bialystok"));
        connections.add(new Flight("Gdansk", "Radom"));

        return connections;
    }
}
