package com.kodilla.patterns2.observer.homework;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTaskTest {
    @Test
    public void testUpdate() {
        //Given
        Student studentIvone = new Student("Ivone", "Horse", "January 2019");
        Student studentPeter = new Student("Peter", "Smith", "May 2020");

        Coach coachAlex = new Coach("Alex", "Pink");
        Coach coachJessie = new Coach("Jessie", "Blue");

        StudentTask ivoneTask = new StudentTask(studentIvone);
        StudentTask peterTask = new StudentTask(studentPeter);

        ivoneTask.registerObserver(coachAlex);
        ivoneTask.registerObserver(coachJessie);
        peterTask.registerObserver(coachJessie);
        //When
        ivoneTask.addTask(new Task("Task 1", "Unit 1"));
        peterTask.addTask(new Task("Task 2", "Unit 1"));
        //Then
        assertEquals(1, coachAlex.getNotifications());
        assertEquals(2, coachJessie.getNotifications());
    }
}
