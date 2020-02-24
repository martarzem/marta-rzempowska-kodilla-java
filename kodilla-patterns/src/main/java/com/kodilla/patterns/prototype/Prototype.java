package com.kodilla.patterns.prototype;

public class Prototype<T> implements Cloneable { //czyli że nadaje się do klonowania
    @Override
    public T clone() throws CloneNotSupportedException {
        return (T)super.clone();
    }
}