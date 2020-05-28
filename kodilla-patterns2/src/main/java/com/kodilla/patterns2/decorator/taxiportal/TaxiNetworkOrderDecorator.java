package com.kodilla.patterns2.decorator.taxiportal;

import java.math.BigDecimal;

// zwykłe taxi
public class TaxiNetworkOrderDecorator extends AbstractTaxiOrderDecorator {
    public TaxiNetworkOrderDecorator(TaxiOrder taxiOrder) {
        super(taxiOrder);
    }

    @Override
    public BigDecimal getCost() {
        // hardcoded stub cost = 35
        return super.getCost().add(new BigDecimal(35)); //do podstawowego kosztu dodawany jest koszt przejazdu
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " by Taxi Network";
    }
}
