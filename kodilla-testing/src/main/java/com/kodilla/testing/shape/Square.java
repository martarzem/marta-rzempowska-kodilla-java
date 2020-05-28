package com.kodilla.testing.shape;

public class Square implements Shape {

    private String shapeName;
    private double side;

    public Square(String shapeName, double side) {
        this.shapeName = shapeName;
        this.side = side;
    }

    public String getShapeName() {
        return shapeName;
    }

    public double getField() {
        return side * side;
    }
}
