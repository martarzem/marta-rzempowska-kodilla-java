package com.kodilla.hibernate.task;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

//klasa reprezentująca zadanie do wykonania
@Entity
@Table(name = "TASKS")
public final class Task {
    private int id;
    private String description;
    private Date created;
    private int duration;

    public Task() {
    }

    //konstruktor inicjuje 3 pola
    public Task(String description, int duration) {
        this.description = description;
        this.created = new Date(); //automatycznie inicjuje bieżącą datęv
        this.duration = duration;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    @NotNull
    @Column(name = "CREATED")
    public Date getCreated() {
        return created;
    }

    @Column(name = "DURATION")
    public int getDuration() {
        return duration;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    private void setCreated(Date created) {
        this.created = created;
    }

    private void setDuration(int duration) {
        this.duration = duration;
    }
}