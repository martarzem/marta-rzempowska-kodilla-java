package com.kodilla.testing2.ebay;

import com.kodilla.testing2.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class EBayTestingApp {
    public final static String SEARCHFIELD = "gh-ac";

    public static void main (String[] args) {
        WebDriver webDriver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        webDriver.get("https://www.ebay.com");

        WebElement searchField = webDriver.findElement(By.id(SEARCHFIELD));
        searchField.sendKeys("Laptop");
        searchField.submit();
    }
}
