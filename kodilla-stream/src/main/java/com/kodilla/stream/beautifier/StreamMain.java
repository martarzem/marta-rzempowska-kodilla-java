package com.kodilla.stream.beautifier;

public class StreamMain {
    public static void main(String[] args) {

        PoemBeautifier poemBeautifier = new PoemBeautifier();

        System.out.println(poemBeautifier.beautify("butter", (word) -> "#" + word + "#"));
        System.out.println(poemBeautifier.beautify("egg", (word) -> word.toUpperCase()));
        System.out.println(poemBeautifier.beautify("water", (word) -> word + "-" + word));
    }
}