package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
//powyższe adnotacje potrzebne do zainicjowania kontenera Springa
public class TaskDaoTestSuite {
    @Autowired //tworzenie obiektu zadeklarowanego kontrolera repozytorium
    private TaskDao taskDao; //pole przechowujące referencję do kontrolera repozytorium
    private static final String DESCRIPTION = "Test: Learn Hibernate";

    @Test
    public void testTaskDaoSave() {
        //Given
        Task task = new Task(DESCRIPTION, 7); //tworzony jest obiekt Task,
        //który jako description ma ustawioną stałą i czas trwania = 7

        //When
        taskDao.save(task); //wywołanie metody interfejsu (zapisanie obiektu w bazie)

        //Then
        int id = task.getId();
        Optional<Task> readTask = taskDao.findById(id);
        Assert.assertTrue(readTask.isPresent());
        //sprawdza, czy operacja się powiodła
        //poprzez getter getId() sprawdzany, jaki identyfikator został nadany
        //za pomocą findById() pobieramy obiekt o danym Id (metoda zwraca Optional <Task>
        //za pomocą isPresent sprawdzamy, czy obiekt istnieje (czy Optional zawiera Task)

        //CleanUp
        taskDao.deleteById(id);
        //sprzątanie po testach (stan po wykonaniu testów musi być taki sam jak przed testami)
    }

    @Test //czy działa zadeklarowana przez nas metoda
    //nie napisaliśmy metody findByDuration
    //a także nie powołaliśmy do życia obiektu implementującego TaskDao
    //tym zajęli się Hibernate i Spring
    public void testTaskDaoFindByDuration() {
        //Given
        Task task = new Task(DESCRIPTION, 7);
        taskDao.save(task);
        int duration = task.getDuration();
        //tworzymy obiekt i zapisujemy go w bazie
        //zapamiętujemy, ile wynosi duration

        //When
        List<Task> readTasks = taskDao.findByDuration(duration);
        //wywołujemy testowaną metodę

        //Then
        Assert.assertEquals(1, readTasks.size());
        //sprawdzamy, czy został zwrócony dokładnie 1 rekord

        //CleanUp
        int id = readTasks.get(0).getId();
        taskDao.deleteById(id);
    }
}
