package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity() {
        Continent europe = new Continent("Europe");
        Continent asia = new Continent("Asia");
        Continent africa = new Continent("Africa");

        Country poland = new Country("Poland", BigDecimal.valueOf(2598743));
        Country germany = new Country("Germany", BigDecimal.valueOf(659876));
        Country france = new Country("France", BigDecimal.valueOf(365987));

        Country china = new Country("China", BigDecimal.valueOf(1236598));
        Country japan = new Country("Japan", BigDecimal.valueOf(1256598));
        Country india = new Country("India", BigDecimal.valueOf(1236589));

        Country egypt = new Country("Egypt", BigDecimal.valueOf(125656));
        Country kenya = new Country("Kenya", BigDecimal.valueOf(985647));
        Country morocco = new Country("Morocco", BigDecimal.valueOf(548745));

        europe.addCountry(poland);
        europe.addCountry(germany);
        europe.addCountry(france);

        asia.addCountry(china);
        asia.addCountry(japan);
        asia.addCountry(india);

        africa.addCountry(egypt);
        africa.addCountry(kenya);
        africa.addCountry(morocco);

        World world = new World();

        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(africa);

        BigDecimal result = world.getPeopleQuantity();

        Assert.assertEquals(BigDecimal.valueOf(9014439), result);
    }
}
