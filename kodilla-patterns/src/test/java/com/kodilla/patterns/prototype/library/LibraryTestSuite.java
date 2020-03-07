package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {
    @Test
    public void testGetBooks() {
        Library library = new Library("Original Fantasy");
        for (int n = 0; n < 5; n++) {
            library.getBooks().add(new Book("Title" + n, "Author" + n,
                    LocalDate.of(2000 + n, 1 + n, 10 + n)));
        }

        //making a shallow copy of library object
        Library shallowClonedLibrary = null;
        try {
            shallowClonedLibrary = library.shallowCopy();
            shallowClonedLibrary.setName("Shallow Criminals");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //making a deep copy of library object
        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Deep Horrors");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        System.out.println(library.getName());
        library.getBooks().stream()
                .forEach(x -> System.out.println(x));
        System.out.println(shallowClonedLibrary.getName());
        shallowClonedLibrary.getBooks().stream()
                .forEach(x -> System.out.println(x));
        System.out.println(deepClonedLibrary.getName());
        deepClonedLibrary.getBooks()
                .forEach(System.out::println);

        Book b = new Book("Title" + 0, "Author" + 0,
                LocalDate.of(2000 + 0, 1 + 0, 10 + 0));
        System.out.println(library.getBooks().size());
        library.getBooks().remove(b);
        System.out.println(library.getBooks().size());

        Assert.assertEquals(4, library.getBooks().size());
        Assert.assertEquals(4, shallowClonedLibrary.getBooks().size());
        Assert.assertEquals(5, deepClonedLibrary.getBooks().size());

    }
}
