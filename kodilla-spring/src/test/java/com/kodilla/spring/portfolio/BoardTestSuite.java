package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {

    @Test
    public void testAddTask() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        board.getToDoList().addTask("Task to do.");
        board.getInProgressList().addTask("Task in progress.");
        board.getDoneList().addTask("Task done.");

        String resultToDoList = board.getToDoList().getTasks(0);
        String resultInProgressList = board.getInProgressList().getTasks(0);
        String resultDoneList = board.getDoneList().getTasks(0);

        Assert.assertEquals("Task to do.", resultToDoList);
        Assert.assertEquals("Task in progress.", resultInProgressList);
        Assert.assertEquals("Task done.", resultDoneList);
    }
}
