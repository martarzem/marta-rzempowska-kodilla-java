package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {
    static double getAverage(int[] numbers) {
        IntStream.range(0, numbers.length)
                .map(n -> numbers[n]) //potrzebne, bo inaczej wyświetla liczby od 0 do wielkości listy, a nie liczby z listy
                .forEach(System.out::println);
        return IntStream.range(0, numbers.length)
                .map(n -> numbers[n]) //potrzebne, bo inaczej wyświetla liczby od 0 do wielkości listy, a nie liczby z listy
                .average()
                .orElse(0); //w razie gdyby lista była pusta
        //PYTANIE: jak wyświetlić tutaj informację, że lista jest pusta
    }
}