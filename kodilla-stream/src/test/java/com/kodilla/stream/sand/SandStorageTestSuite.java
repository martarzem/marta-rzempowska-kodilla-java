package com.kodilla.stream.sand;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SandStorageTestSuite {
    @Test
    public void testGetSandBeansQuantity() {
        //Given
        List<SandStorage> continents = new ArrayList<>();
        continents.add(new Europe());
        continents.add(new Asia());
        continents.add(new Africa());

        //When
        BigDecimal totalSand = BigDecimal.ZERO;
        for(SandStorage continent : continents){
            totalSand = totalSand.add(continent.getSandBeansQuantity());
        }

        //Then
        BigDecimal expectedSand = new BigDecimal("211111110903703703670");
        Assert.assertEquals(expectedSand, totalSand);
    }

    @Test
    public void testGetSandBeansQuantityWithReduce() {
        //Given
        List<SandStorage> continents = new ArrayList<>();
        continents.add(new Europe());
        continents.add(new Asia());
        continents.add(new Africa());

        //When
        BigDecimal totalSand = continents.stream() //uruchamiamy strumień i jego wynik przypisujemy do zmiennej
                .map(SandStorage::getSandBeansQuantity) //zamiana obiektów reprezentujących kontynenty na liczby typu
                // BigDecimal będące ilością ziarenek piasku
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current)); //wartość początkowa kolektora skalarnego
                // to zero,  dla każdej liczby w kolekcji wykonuje wyrażenie lambda; końcowa suma jest zwracana do
                // zmiennej totalSand

        //Then
        BigDecimal expectedSand = new BigDecimal("211111110903703703670");
        Assert.assertEquals(expectedSand, totalSand);
    }
}