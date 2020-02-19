package com.kodilla.spring.library;

import java.util.ArrayList;
import java.util.List;

/* WSTRZYKIWANIE ZALEŻNOŚCI PRZEZ KONSTRUKTOR
@Service
public final class Library {
    private final List<String> books = new ArrayList<>();
    private final LibraryDbController libraryDbController; //pole przechowujące referencję do obiektu klasy LibraryDbController

    public Library(final LibraryDbController libraryDbController) { //pole jest inicjowane przez konstruktor
        this.libraryDbController = libraryDbController;
    }

    public void saveToDb() {
        libraryDbController.saveData();
    }

    public void loadFromDb() {
        libraryDbController.loadData();
    }
}

 */

/*ADNOTACJA @AUTOWIRED
@Service
public final class Library {
    private final List<String> books = new ArrayList<>();
    private LibraryDbController libraryDbController; //usuwamy final

    @Autowired //wskazujemy, którego konstruktora Spring ma użyć do wstrzyknięcia Beana
    public Library(final LibraryDbController libraryDbController) {
        this.libraryDbController = libraryDbController;
    }

    public Library() { //dodajemy konstruktor bezparametrowy
        // do nothing
    }

    public void saveToDb() {
        libraryDbController.saveData();
    }

    public void loadFromDb() {
        libraryDbController.loadData();
    }
}

 */

/*WSTRZYKIWANIE ZALEŻNOŚCI PRZEZ METODĘ
@Service
public final class Library {
    private final List<String> books = new ArrayList<>();
    private LibraryDbController libraryDbController;

    //Spring nie może użyć konstruktora do wstrzyknięcia Beana, bo nie ma konstruktora
    //w zamian za to dostał klasę do tego celu
    @Autowired //Springu, użyj tej metody do wstrzyknięcia zależności
    public void setLibraryDbController(LibraryDbController libraryDbController) {
        this.libraryDbController = libraryDbController;
    }

    public void saveToDb() {
        libraryDbController.saveData();
    }

    public void loadFromDb() {
        libraryDbController.loadData();
    }
}
 */

/*WSTRZYKIWANIE ZALEŻNOŚCI DO WŁAŚCIWOŚCI KLASY
@Service
public final class Library {
    private final List<String> books = new ArrayList<>();

    @Autowired
    private LibraryDbController libraryDbController;

    public void saveToDb() {
        libraryDbController.saveData();
    }

    public void loadFromDb() {
        libraryDbController.loadData();
    }
}
 */

//KONFIGURACJA PRZY POMOCY KLASY JAVA
public final class Library {
    private final List<String> books = new ArrayList<>();
    private LibraryDbController libraryDbController;

    public Library(final LibraryDbController libraryDbController) { //usuwamy adnotacje @Autowired
        this.libraryDbController = libraryDbController; //i tworzymy klasę LibraryConfig
    }

    public Library() {
    }

    public void saveToDb() {
        libraryDbController.saveData();
    }

    public void loadFromDb() {
        libraryDbController.loadData();
    }
}