package com.kodilla.spring.library;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LibraryConfig { //tworzymy klasę konfiguracyjną
    @Bean
    public Library library() {
        return new Library(libraryDbController());
    }

    @Bean
    public LibraryDbController libraryDbController() {
        return new LibraryDbController();
    }
}

/*
mamy dwie metody tworzące obiekty
metoda libraryDbController tworzy obiekt, który jest wstrzykiwany do obiektu
    tworzonego przy pomocy metody library
wewnątrz metody library jest odwołanie do konstruktora, gdzie jawnie wskazujemy
    jakiego obiektu trzeba użyć do utworzenia obiektu
 */