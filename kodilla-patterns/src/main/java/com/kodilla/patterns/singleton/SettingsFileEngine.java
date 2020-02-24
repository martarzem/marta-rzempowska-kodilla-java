package com.kodilla.patterns.singleton;

//klasa do odczytu i zapisu ustawień aplikacji z pliku
public final class SettingsFileEngine {
    private static SettingsFileEngine settingsFileEngineInstance = null;
    private String fileName = "";

    private SettingsFileEngine() {
    }

    public static SettingsFileEngine getInstance() {
        /*
        if (settingsFileEngineInstance == null) { //sprawdza, czy pole jest zainicjowane
            settingsFileEngineInstance = new SettingsFileEngine(); //jeśli nie - tworzy nowy obiekt klasy
        }
         */
        //uniknięcie problemu z wielowątkowością
        if (settingsFileEngineInstance == null) {
            synchronized(SettingsFileEngine.class) {
                if (settingsFileEngineInstance == null) { //podwójne sprawdzenie, czy obiekt nie istnieje
                    settingsFileEngineInstance = new SettingsFileEngine();
                }
            }
        }
        return settingsFileEngineInstance;
    }

    //zwraca nazwę otwartego pliku z ustawieniami
    public String getFileName() {
        return fileName;
    }

    //otwieranie pliku z ustawieniami
    public void open(final String fileName) {
        this.fileName = fileName;
        System.out.println("Opening the settings file");
    }

    //zamykanie pliku z ustawieniami
    public void close() {
        this.fileName = "";
        System.out.println("Closing the settings file");
    }

    //odczytywanie ustawień aplikacji
    public boolean loadSettings() {
        System.out.println("Loading settings from file");
        return true;
    }

    //zapisywanie ustawień aplikacji
    public boolean saveSettings() {
        System.out.println("Saving settings to file");
        return true;
    }
}
