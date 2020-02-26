package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBuildBigmac() {
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .setBun("with sesame")
                .setBurgers(2)
                .setIngredients("onion")
                .setIngredients("lettuce")
                .setIngredients("tomato")
                .build();

        int howManyIngredients = bigmac.getIngredients().size();

        Assert.assertEquals(3, howManyIngredients);
    }
}
