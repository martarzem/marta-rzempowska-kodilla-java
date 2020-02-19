package com.kodilla.exception.nullpointer;


// tworzymy wyjątek
public class MessageNotSentException extends Exception {
    public MessageNotSentException(final String message) {
        super(message);
    }
}
