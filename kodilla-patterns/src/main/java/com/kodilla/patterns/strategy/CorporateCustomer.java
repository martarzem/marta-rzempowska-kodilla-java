package com.kodilla.patterns.strategy;

import com.kodilla.patterns.strategy.predictors.BalancedPredictor;

//klient korporacyjny, umiarkowane ryzyko inwestowania
public class CorporateCustomer extends Customer {
    public CorporateCustomer(String name) {
        super(name);
        this.buyPredictor = new BalancedPredictor(); //klasa sama określa, jaka ma być jej domyślna strategia
    }
}
