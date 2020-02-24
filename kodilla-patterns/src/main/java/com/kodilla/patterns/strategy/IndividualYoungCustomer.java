package com.kodilla.patterns.strategy;

import com.kodilla.patterns.strategy.predictors.AggressivePredictor;
import com.kodilla.patterns.strategy.predictors.BalancedPredictor;

//klienci indywidualni, agresywnie inwestujący
public class IndividualYoungCustomer extends Customer {
    public IndividualYoungCustomer(String name) {
        super(name);
        this.buyPredictor = new AggressivePredictor(); //klasa sama określa, jaka ma być jej domyślna strategia

    }
}
