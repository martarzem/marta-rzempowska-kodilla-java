package com.kodilla.spring.shape;

public class Square implements Shape { //klasa celowo nie oznaczona adnotacją @Component
    @Override
    public String getShapeName() {
        return "This is a square.";
    }
}
