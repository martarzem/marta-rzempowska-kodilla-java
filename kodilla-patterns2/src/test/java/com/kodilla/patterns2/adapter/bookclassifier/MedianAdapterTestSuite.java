package com.kodilla.patterns2.adapter.bookclassifier;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;


public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedianTest() {
        //Given
        Set<com.kodilla.patterns2.adapter.bookclassifier.librarya.Book> bookSet = new HashSet<>();
        bookSet.add(new com.kodilla.patterns2.adapter.bookclassifier.librarya.Book("Fantasy author",
                "Fantasy title", 2000, "Fantasy signature"));
        bookSet.add(new com.kodilla.patterns2.adapter.bookclassifier.librarya.Book("Criminal author",
                "Criminal title", 2010, "Criminal signature"));
        bookSet.add(new com.kodilla.patterns2.adapter.bookclassifier.librarya.Book("Horror author",
                "Horror title", 2015, "Horror signature"));

        MedianAdapter medianAdapter = new MedianAdapter();

        //When
        int result = medianAdapter.publicationYearMedian(bookSet);

        //Then
        assertEquals(2010, result);
    }
}
