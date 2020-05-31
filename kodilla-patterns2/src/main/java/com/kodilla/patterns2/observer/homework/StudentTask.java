package com.kodilla.patterns2.observer.homework;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StudentTask implements Observable {
    private final List<Task> tasks;
    private final Student student;
    private final List<Observer> observers;

    public StudentTask(Student student) {
        tasks = new ArrayList<>();
        this.student = student;
        observers = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers) {
            observer.update(this);
        }
    }
}
