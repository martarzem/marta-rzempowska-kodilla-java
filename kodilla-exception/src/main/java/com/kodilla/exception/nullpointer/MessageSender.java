package com.kodilla.exception.nullpointer;

public class MessageSender {

    /*
    public void sendMessageTo(User user, String message) {
        System.out.println("Sending message: " + message + " to: " + user.getName());
    }


    // lepsza wersja - aby ustrzec się przed błędem NullPointerException
    public void sendMessageTo(User user, String message) {
        if(user != null) {
            System.out.println("Sending message: " + message + " to: " + user.getName());
        }
    }

     */

    // rzucamy utworzonym wyjątkiem
    public void sendMessageTo(User user, String message) throws MessageNotSentException {
        if(user != null) {
            System.out.println("Sending message: " + message + " to: " + user.getName());
        } else {
            throw new MessageNotSentException("Object User was null");
        }
    }
}
