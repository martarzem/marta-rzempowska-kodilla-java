package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public String beautify(String word, PoemDecorator poemDecorator) {
        return poemDecorator.decorate(word);
    }
}
