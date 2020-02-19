package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverageEmptyArray() {
        int[] numbers = {};
        double result = ArrayOperations.getAverage(numbers);

        Assert.assertEquals(0, result, 0);
    }

    @Test
    public void testGetAverage() {
        int[] numbers = {2,3,4,6,2,5,3,6,4,6};
        double result = ArrayOperations.getAverage(numbers);

        Assert.assertEquals(4.1, result, 0);
    }
}



