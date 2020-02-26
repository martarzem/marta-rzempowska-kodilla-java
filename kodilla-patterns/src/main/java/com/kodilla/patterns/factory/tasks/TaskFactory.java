package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPINGTASK = "ShoppingTask";
    public static final String PAINTINGTASK = "PaintingTask";
    public static final String DRIVINGTASK = "DrivingTask";

    public Task makeTask (String taskClass) {
        switch (taskClass) {
            case SHOPPINGTASK:
                return new ShoppingTask("Christmas gift", "Cinema's tickets",
                        2);
            case PAINTINGTASK:
                return new PaintingTask("Picture", "Brown and white", "Cow");
            case DRIVINGTASK:
                return new DrivingTask("Travel", "Italy", "Car");
            default:
                return null;
        }
    }

}
