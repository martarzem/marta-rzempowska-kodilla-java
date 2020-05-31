package com.kodilla.patterns2.observer.homework;

import lombok.Data;
import lombok.Getter;

@Data
public class Coach implements Observer {
    private String name;
    private String lastname;
    private int notifications;

    public Coach(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    @Override
    public void update(StudentTask studentTask) {
        notifications++;
        System.out.println("New task is ready from " + studentTask.getStudent().getName());
    }
}
