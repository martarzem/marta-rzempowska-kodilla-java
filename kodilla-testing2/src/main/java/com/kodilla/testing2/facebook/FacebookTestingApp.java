package com.kodilla.testing2.facebook;

import com.kodilla.testing2.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public final static String XPATH_DAYFIELD = "//div[@class=\"_5k_5\"]/span/span/select[1]";
    public final static String XPATH_MONTHFIELD = "//div[@class=\"_5k_5\"]/span/span/select[2]";
    public final static String XPATH_YEARFIELD = "//div[@class=\"_5k_5\"]/span/span/select[3]";

    public static void main(String[] args) {
        WebDriver webDriver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        webDriver.get("https://www.facebook.com");

        while(!webDriver.findElement(By.xpath(XPATH_DAYFIELD)).isDisplayed());

        WebElement selectComboDay = webDriver.findElement(By.xpath(XPATH_DAYFIELD));
        Select selectDay = new Select(selectComboDay);
        selectDay.selectByIndex(28);

        WebElement selectComboMonth = webDriver.findElement(By.xpath(XPATH_MONTHFIELD));
        Select selectMonth = new Select(selectComboMonth);
        selectMonth.selectByIndex(10);

        WebElement selectComboYear = webDriver.findElement(By.xpath(XPATH_YEARFIELD));
        Select selectYear = new Select(selectComboYear);
        selectYear.selectByIndex(28);
    }
}
