package com.kodilla.patterns.strategy;

//zeprezentuje klienta
public class Customer {
    final private String name;
    protected BuyPredictor buyPredictor; //przypisuje właściwy obiekt implementujący interfejs

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String predict() {
        return buyPredictor.predictWhatToBuy();
    }

    public void setBuyingStrategy(BuyPredictor buyPredictor) {
        this.buyPredictor = buyPredictor;
    }
}
