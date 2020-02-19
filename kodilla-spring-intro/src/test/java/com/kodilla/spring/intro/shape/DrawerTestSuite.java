package com.kodilla.spring.intro.shape;

import org.junit.Assert;
import org.junit.Test;

public class DrawerTestSuite {

    /*
    //TEST DO KLASY DRAWER, KTÓRA SAMA TWORZYŁA OBIEKTY
    @Test
    public void testDoDrawing() {
        //Given
        Drawer drawer = new Drawer();
        //When
        drawer.doDrawing();
        //Then
        //do nothing
    }
     */

    //TESTY ''DLA KLASY DRAWER'', Z KTÓREJ WYCIĄGNĘLIŚMY ZALEŻNOŚCI(NIE TWORZY SAMA OBIEKTÓW)
    @Test
    public void testDoDrawingWithCircle() {
        //Given
        Circle circle = new Circle();
        //When
        Drawer drawer = new Drawer(circle);
        String result = drawer.doDrawing();
        //Then
        Assert.assertEquals("This is a circle", result);
    }

    @Test
    public void testDoDrawingWithTriangle() {
        //Given
        Triangle triangle = new Triangle();
        //When
        Drawer drawer = new Drawer(triangle);
        String result = drawer.doDrawing();
        //Then
        Assert.assertEquals("This is a triangle", result);
    }
}
