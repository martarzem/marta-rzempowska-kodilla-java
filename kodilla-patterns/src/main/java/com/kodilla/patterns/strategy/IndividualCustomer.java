package com.kodilla.patterns.strategy;

import com.kodilla.patterns.strategy.predictors.BalancedPredictor;
import com.kodilla.patterns.strategy.predictors.ConservativePredictor;

//dojrzali klienci, nieryzykujący, niska stopa, ale pewne akcje
public class IndividualCustomer extends Customer {
    public IndividualCustomer(String name) {
        super(name);
        this.buyPredictor = new ConservativePredictor(); //klasa sama określa, jaka ma być jej domyślna strategia

    }
}
