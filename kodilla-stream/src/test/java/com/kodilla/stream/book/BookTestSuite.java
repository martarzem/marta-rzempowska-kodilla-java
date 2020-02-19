package com.kodilla.stream.book;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

public class BookTestSuite {
    @Test //test z użyciem pętli for-each
    public void testGetListUsingFor() {
        //Given
        BookDirectory bookDirectory = new BookDirectory();

        //When
        List<Book> books = bookDirectory.getList(); //pobieramy kolekcję książek za pomocą getList()

        //Then
        int numberOfBooksPublicatedAfter2007 = 0;
        for(Book book : books) {
            if (book.getYearOfPublication() > 2007) {
                numberOfBooksPublicatedAfter2007++;
            }
        }
        Assert.assertEquals(3, numberOfBooksPublicatedAfter2007);
    }

    @Test //test z użyciem IntStream
    public void testGetListUsingIntStream() {
        //Given
        BookDirectory bookDirectory = new BookDirectory();

        //When
        List<Book> books = bookDirectory.getList();

        //Then
        int numberOfBooksPublicatedAfter2007 = IntStream.range(0, books.size()) //uruchamiamy strumień elementó typu Int
                .filter(n -> books.get(n).getYearOfPublication() > 2007) //dalej puszczane są NUMERY INDEKSÓW (nie książki),
                // których książki spełniają warunek publikacji po 2007 roku
                .map(n -> 1) //każdy indeks jest transformowany do jedynki
                .sum(); // sumujemy jedynki
        Assert.assertEquals(3, numberOfBooksPublicatedAfter2007);
    }

    @Test //test z użyciem IntStream oraz count() (żeby nie zamieniać indeksów na jedynki)
    public void testGetListUsingIntStreamPart2() {
        //Given
        BookDirectory bookDirectory = new BookDirectory();

        //When
        List<Book> books = bookDirectory.getList();

        //Then
        long numberOfBooksPublicatedAfter2007 = IntStream.range(0, books.size()) //count() zwraca typ long
                .filter(n -> books.get(n).getYearOfPublication() > 2007)
                .count();
        Assert.assertEquals(3, numberOfBooksPublicatedAfter2007);
    }
}