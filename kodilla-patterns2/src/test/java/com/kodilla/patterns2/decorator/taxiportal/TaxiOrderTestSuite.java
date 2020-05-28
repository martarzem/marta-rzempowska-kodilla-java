package com.kodilla.patterns2.decorator.taxiportal;

// import org.junit.Test;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TaxiOrderTestSuite {
    @Test
    public void testBasicTaxiOrderGetCost() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        // Then
        assertEquals(new BigDecimal(5), calculatedCost);
    }

    @Test
    public void testBasicTaxiOrderGeDescription() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        // When
        String description = theOrder.getDescription();
        // Then
        assertEquals("Drive a course", description);
    }

    @Test
    public void testTaxiNetworkGetCost() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        // When
        BigDecimal theCost = theOrder.getCost();
        // Then
        assertEquals(new BigDecimal(40), theCost);
    }

    @Test
    public void testTaxiNetworkGetDescription() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        // When
        String description = theOrder.getDescription();
        // Then
        assertEquals("Drive a course by Taxi Network", description);
    }

    @Test
    public void testMyTaxiWithChildSeatGetCost() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new MyTaxiNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        // When
        BigDecimal theCost = theOrder.getCost();
        // Then
        assertEquals(new BigDecimal(37), theCost);
    }

    @Test
    public void testMyTaxiWithChildSeatGetDescription() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new MyTaxiNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        // When
        String description = theOrder.getDescription();
        // Then
        assertEquals("Drive a course by MyTaxi Network + child seat", description);
    }

    @Test
    public void testUberWithTwoChildSeatsGetCost() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new UberNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder); //chcemy dwa foteliki dla dziecka
        // When
        BigDecimal theCost = theOrder.getCost();
        // Then
        assertEquals(new BigDecimal(29), theCost);
    }

    @Test
    public void testUberWithTwoChildSeatsGetDescription() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new UberNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        // When
        String description = theOrder.getDescription();
        // Then
        assertEquals("Drive a course by Uber Network + child seat + child seat", description);
    }

    @Test
    public void testVipTaxiWithChildSeatGetCost() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder); //Taxi Network
        theOrder = new VipDecorator(theOrder); //wariant VIP
        theOrder = new ChildSeatDecorator(theOrder); //fotelik dla dziecka
        System.out.println(theOrder.getCost());
        // When
        BigDecimal theCost = theOrder.getCost();
        // Then
        assertEquals(new BigDecimal(52), theCost);
    }

    @Test
    public void testVipTaxiWithChildSeatGetDescription() {
        // Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder); //Taxi Network
        theOrder = new VipDecorator(theOrder); //wariant VIP
        theOrder = new ChildSeatDecorator(theOrder); //fotelik dla dziecka
        System.out.println(theOrder.getDescription());
        // When
        String description = theOrder.getDescription();
        // Then
        assertEquals("Drive a course by Taxi Network + variant VIP + child seat", description);
    }


}