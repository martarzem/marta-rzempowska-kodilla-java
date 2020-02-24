package com.kodilla.patterns.factory;

public final class ShapeFactory {
    public static final String CIRCLE = "CIRCLE"; //definiujemy stałe, których będziemy używać
    public static final String SQUARE = "SQUARE"; //żeby uniknąć literówek
    public static final String RECTANGLE = "RECTANGLE";

    public final Shape makeShape(final String shapeClass) { //sprawdza, którą ze stałych użyto...
        switch (shapeClass) {
            case CIRCLE:
                return new Circle("The rounded circle", 4.50); //...i tworzy obiekt odpowiadający tej stałej
            case SQUARE:
                return new Square("The angular square", 7.0);
            case RECTANGLE:
                return new Rectangle("The long rectangle", 15.0, 2.50);
            default:
                return null;
        }

    }
}