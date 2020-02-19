package com.kodilla.spring.intro.shape;

public class Triangle implements Shape {

    /* WERSJA DLA DZIEDZICZENIA PO FIGURE
    @Override
    public void draw() {
        System.out.println("This is a triangle");
    }

     */

    //WERSJA DLA IMPLEMENTOWANIA SHAPE
    @Override
    public String draw() {
        System.out.println("This is a triangle");
        return "This is a triangle";
    }
}
