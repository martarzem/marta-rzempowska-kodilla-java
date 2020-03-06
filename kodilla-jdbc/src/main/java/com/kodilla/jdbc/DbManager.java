package com.kodilla.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//klasa odpowiedzialna za łączenie się z bazą; spełnia wzorzec Singleton
public class DbManager {
    private Connection conn; //referencja do obiektu przechowującego połączenie do bazy
    private static DbManager dbManagerInstance; //potrzebne, by zawsze była jedna instancja obiektu klasy DbManager

    private DbManager() throws SQLException { //prywatny konstruktor (nie można go wywołać spoza tej klasy)
        Properties connectionProps = new Properties(); //tworzymy obiekt klasy Properties
        connectionProps.put("user", "kodilla_user"); //ustawienie usera zdefiniowanego wcześniej
        connectionProps.put("password", "kodilla_password"); //ustawienie hasła zdefiniowanego wcześniej
        //tworzenie połączenia do bazy poprzez statyczną metodę getConnection klasy DriverManager
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kodilla_course?serverTimezone=Europe/Warsaw" +
                        "&useSSL=False",
                connectionProps);
    }

    public static DbManager getInstance() throws SQLException { //jeśli jeszcze nie ma, to tworzy obiekt klasy DbManager
        if (dbManagerInstance == null) {
            dbManagerInstance = new DbManager();
        }
        return dbManagerInstance;
    }

    public Connection getConnection() {
        return conn;
    }
}