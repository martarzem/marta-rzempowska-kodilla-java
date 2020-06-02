package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.BookSignature;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {

    @Override
    public int publicationYearMedian(Set<com.kodilla.patterns2.adapter.bookclassifier.librarya.Book> bookSet) {
        Map<BookSignature, com.kodilla.patterns2.adapter.bookclassifier.libraryb.Book> books = new HashMap<>();
        for(com.kodilla.patterns2.adapter.bookclassifier.librarya.Book book : bookSet) {
            books.put(new BookSignature(book.getSignature()),
                    new com.kodilla.patterns2.adapter.bookclassifier.libraryb.Book(
                    book.getAuthor(), book.getTitle(), book.getPublicationYear()));
        }
        return  medianPublicationYear(books);
    }
}
