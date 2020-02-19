package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {

    public List<Integer> exterminate (List<Integer> numbers) {
        List<Integer> oddNumbers = new ArrayList<>();
        if (!numbers.isEmpty()) {
            List<Integer> copyNumbers = new ArrayList<>(numbers);
            for (Integer number : copyNumbers) {
                if (number%2 == 0) {
                    oddNumbers.add(number);
                }
            }
            if (oddNumbers.isEmpty()) {
                System.out.println("There are no odd numbers");
            }
        } else {
            System.out.println("The list is empty.");
        }
        return oddNumbers;
    }
}
