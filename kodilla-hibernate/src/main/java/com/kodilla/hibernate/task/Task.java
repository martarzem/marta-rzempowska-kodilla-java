package com.kodilla.hibernate.task;

import com.kodilla.hibernate.tasklist.TaskList;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@NamedQueries({
        @NamedQuery(
                name = "Task.retrieveLongTasks",
                query = "FROM Task WHERE duration > 10"
        ),
        @NamedQuery(
                name = "Task.retrieveShortTasks",
                query = "FROM Task WHERE duration <= 10"
        ),
        @NamedQuery(
                name = "Task.retrieveTasksWithDurationLongerThan",
                query = "FROM Task WHERE duration > :DURATION"
        )
})

@NamedNativeQuery(
        name = "Task.retrieveTasksWithEnoughTime",
        query = "SELECT * FROM TASKS" +
                " WHERE DATEDIFF(DATE_ADD(CREATED, INTERVAL DURATION DAY), NOW()) > 5",
        resultClass = Task.class
)

//klasa reprezentująca zadanie do wykonania
@Entity
@Table(name = "TASKS")
public final class Task {
    private int id;
    private String description;
    private Date created;
    private int duration;
    private TaskFinancialDetails taskFinancialDetails; //referencja do obiektu (tworzenie relacji między encjami)
    private TaskList taskList; //do której listy należy zadanie

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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "TASKS_FINANCIALS_ID") //jak ma nazwać kolumnę z kluczem obcym
    public TaskFinancialDetails getTaskFinancialDetails() {
        return taskFinancialDetails;
    }

    @ManyToOne
    @JoinColumn(name = "TASKLIST_ID")
    public TaskList getTaskList() {
        return taskList;
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

    //publiczny setter, bo wywołujemy go w testach
    public void setTaskFinancialDetails(TaskFinancialDetails taskFinancialDetails) {
        this.taskFinancialDetails = taskFinancialDetails;
    }

    //publiczny setter, bo będzie wykorzystywany w testach
    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }
}