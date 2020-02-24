package com.kodilla.patterns.builder.pizza;

import java.util.ArrayList;
import java.util.List;
/* klasa z długim konstruktorem
public final class Pizza {


    private final String bottom;
    private final String sauce;
    private final List<String> ingredients = new ArrayList<>();

    public Pizza(final String bottom, final String sauce, final String... ingredients) {
        this.bottom = bottom;
        this.sauce = sauce;
        for (int n = 0; n < ingredients.length; n++) { //otwarta lista składników
            this.ingredients.add(ingredients[n]);
        }
    }

    public String getBottom() {
        return bottom;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "bottom='" + bottom + '\'' +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}

     */

    //zastosowanie wzorca builder
    public final class Pizza {
        private final String bottom;
        private final String sauce;
        private final List<String> ingredients;

        public static class PizzaBuilder { //wewnętrzna klasa (inner class)
            private String bottom;
            private String sauce;
            private List<String> ingredients = new ArrayList<>();

            public PizzaBuilder bottom(String bottom) { //setter
                this.bottom = bottom;
                return this; //zwraca this tzn. że możemy kaskadowo łączyć wywołania setterów
            }

            public PizzaBuilder sauce(String sauce) { //setter
                this.sauce = sauce;
                return this;
            }

            public PizzaBuilder ingredient(String ingredient) { //setter
                ingredients.add(ingredient);
                return this;
            }

            public Pizza build() { //tworzy obiekt klasy Pizza
                return new Pizza(bottom, sauce, ingredients);
            }
        }

        private Pizza(final String bottom, final String sauce, List<String> ingredients) { //prywatny konstruktor ->
            this.bottom = bottom; // aby utworzyć obiekt klasy Pizza trzeba skorzystać z PizzaBuilder
            this.sauce = sauce;
            this.ingredients = new ArrayList<>(ingredients);
        }

        public String getBottom() {
            return bottom;
        }

        public String getSauce() {
            return sauce;
        }

        public List<String> getIngredients() {
            return ingredients;
        }

        @Override
        public String toString() {
            return "Pizza{" +
                    "bottom='" + bottom + '\'' +
                    ", sauce='" + sauce + '\'' +
                    ", ingredients=" + ingredients +
                    '}';
        }
    }
