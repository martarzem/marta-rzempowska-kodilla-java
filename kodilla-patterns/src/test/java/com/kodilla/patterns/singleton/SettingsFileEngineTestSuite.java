package com.kodilla.patterns.singleton;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SettingsFileEngineTestSuite {
    /*
    private static SettingsFileEngine settingsFileEngine;

    @BeforeClass
    public static void openSettingsFile() {
        settingsFileEngine = new SettingsFileEngine();
        settingsFileEngine.open("myapp.settings");
    }

    @AfterClass
    public static void closeSettingsFile() {
        settingsFileEngine.close();
    }

    @Test
    public void testGetFileName() {
        //Given
        //When
        String fileName = settingsFileEngine.getFileName();
        System.out.println("Opened: " + fileName);
        //Then
        Assert.assertEquals("myapp.settings", fileName);
    }

    @Test
    public void testLoadSettings() {
        //Given
        //When
        boolean result = settingsFileEngine.loadSettings();
        //Then
        Assert.assertTrue(result);
    }

    @Test
    public void testSaveSettings() {
        //Given
        //When
        boolean result = settingsFileEngine.saveSettings();
        //Then
        Assert.assertTrue(result);
    }

     */

    //po modyfikacji pod metodę getInstance()
    //nie tworzymy obiektu klasy; nawet nie jest to możliwe przez prywatny konstruktor
    @BeforeClass
    public static void openSettingsFile() {
        SettingsFileEngine.getInstance().open("myapp.settings");
    }

    @AfterClass
    public static void closeSettingsFile() {
        SettingsFileEngine.getInstance().close();
    }

    @Test
    public void testGetFileName() {
        //Given
        //When
        String fileName = SettingsFileEngine.getInstance().getFileName();
        System.out.println("Opened: " + fileName);
        //Then
        Assert.assertEquals("myapp.settings", fileName);
    }

    @Test
    public void testLoadSettings() {
        //Given
        //When
        boolean result = SettingsFileEngine.getInstance().loadSettings();
        //Then
        Assert.assertTrue(result);
    }

    @Test
    public void testSaveSettings() {
        //Given
        //When
        boolean result = SettingsFileEngine.getInstance().saveSettings();
        //Then
        Assert.assertTrue(result);
    }
}