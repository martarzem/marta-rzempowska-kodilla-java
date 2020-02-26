package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {
    @Test
    public void testShoppingTask() {
        TaskFactory factory = new TaskFactory();

        Task shopping = factory.makeTask(TaskFactory.SHOPPINGTASK);

        Assert.assertEquals("Christmas gift", shopping.getTaskName());
    }

    @Test
    public void testPaintingTask() {
        TaskFactory factory = new TaskFactory();

        Task painting = factory.makeTask(TaskFactory.PAINTINGTASK);

        Assert.assertEquals("Picture", painting.getTaskName());
    }

    @Test
    public void testDrivingTask() {
        TaskFactory factory = new TaskFactory();

        Task driving = factory.makeTask(TaskFactory.DRIVINGTASK);

        Assert.assertEquals("Travel", driving.getTaskName());
    }
}
