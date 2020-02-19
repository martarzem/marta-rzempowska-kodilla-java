package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> figuresList = new ArrayList<>();

    public void addFigure(Shape shape) {
        figuresList.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        boolean result = false;
        if (figuresList.contains(shape)) {
            figuresList.remove(shape);
            result = true;
        }
        return result;
    }

    public int getFiguresListSize() {
        return figuresList.size();
    }

    public Shape getFigure(int n) {
        return figuresList.get(n);
    }

    public List<Shape> showFigure() {
        return figuresList;
    }

    public double getShapeField(Shape shape) {
        return shape.getField();
    }
}
