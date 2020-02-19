package com.kodilla.testing.collection;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class CollectionTestSuite {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite started");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite ended");
    }

    @Before
    public void before() {
        System.out.println("Test Case started");
    }

    @After
    public void after() {
        System.out.println("Test Case ended");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        OddNumbersExterminator oddNumber = new OddNumbersExterminator();
        List<Integer> emptyNumberList = new ArrayList<>();
        List<Integer> result = oddNumber.exterminate(emptyNumberList);
        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        OddNumbersExterminator oddNumber = new OddNumbersExterminator();

        List<Integer> numberList = new ArrayList<>();
        numberList.add(2);
        numberList.add(3);
        numberList.add(7);
        numberList.add(26);
        numberList.add(78);
        System.out.println("Basic list: " + numberList);
        List<Integer> oddList = oddNumber.exterminate(numberList);
        System.out.println("List of odd numbers: " + oddList);

        boolean result = true;
        for (Integer number : oddList) {
            if (number % 2 != 0) {
                result = false;
                break;
            }
        }
        Assert.assertTrue(result);
    }
}
