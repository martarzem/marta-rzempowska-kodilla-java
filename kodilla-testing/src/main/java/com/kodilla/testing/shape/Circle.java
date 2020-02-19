package com.kodilla.testing.shape;

public class Circle implements Shape {

    private String shapeName;
    private double radius;

    public Circle(String shapeName, double radius) {
        this.shapeName = shapeName;
        this.radius = radius;
    }

    public String getShapeName() {
        return shapeName;
    }

    public double getField() {
        return Math.PI*radius*radius;
    }
}
