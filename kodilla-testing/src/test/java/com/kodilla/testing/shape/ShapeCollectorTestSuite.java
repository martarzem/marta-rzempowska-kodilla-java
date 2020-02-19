package com.kodilla.testing.shape;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollectorTestSuite {

    private static int testNumber = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("Test Suite started");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("Test Suite ended");
    }

    @Before
    public void beforeEveryTest() {
        testNumber++;
        System.out.println("Executing test no. " + testNumber);
    }

    @Test
    public void testAddFigure() {
        ShapeCollector shapeCollector = new ShapeCollector();
        Circle smallCircle = new Circle("smallCircle", 10);

        shapeCollector.addFigure(smallCircle);

        Assert.assertEquals(1, shapeCollector.getFiguresListSize());
    }

    @Test
    public void testRemoveFigure() {
        ShapeCollector shapeCollector = new ShapeCollector();
        Square smallSquare = new Square("smallSquare", 10);

        shapeCollector.addFigure(smallSquare);
        boolean result = shapeCollector.removeFigure(smallSquare);

        Assert.assertTrue(result);
        Assert.assertEquals(0, shapeCollector.getFiguresListSize());
    }

    @Test
    public void testRemoveFigureNotExisting() {
        ShapeCollector shapeCollector = new ShapeCollector();
        Square smallSquare = new Square("smallSquare", 10);

        boolean result = shapeCollector.removeFigure(smallSquare);

        Assert.assertFalse(result);
    }

    @Test
    public void testGetFigure() {
        ShapeCollector shapeCollector = new ShapeCollector();
        Square smallSquare = new Square("smallSquare", 10);
        shapeCollector.addFigure(smallSquare);

        Shape retrievedFigure = shapeCollector.getFigure(0);

        Assert.assertEquals(smallSquare, retrievedFigure);
    }

    @Test
    public void testShowFigures() {
        ShapeCollector shapeCollector = new ShapeCollector();
        Square smallSquare = new Square("smallSquare", 10);
        Square smallTriangle = new Square("smallTriangle", 14);
        Square smallCircle = new Square("smallCircle", 3);
        shapeCollector.addFigure(smallSquare);
        shapeCollector.addFigure(smallCircle);
        shapeCollector.addFigure(smallTriangle);

        List<Shape> temporaryList = new ArrayList<Shape>();
        temporaryList.add(smallSquare);
        temporaryList.add(smallCircle);
        temporaryList.add(smallTriangle);

        Assert.assertEquals(temporaryList.toString(), shapeCollector.showFigure().toString());
    }

    @Test
    public void testGetSquareField() {
        ShapeCollector shapeCollector = new ShapeCollector();
        double squareField = shapeCollector.getShapeField(new Square("square", 3));

        double squareFieldExpected = 3*3;

        Assert.assertEquals(squareFieldExpected, squareField,0);
    }

    @Test
    public void testGetTriangleField() {
        ShapeCollector shapeCollector = new ShapeCollector();
        double triangleField = shapeCollector.getShapeField(new Triangle("triangle", 2, 4));

        double triangleFieldExpected = 0.5*2*4;

        Assert.assertEquals(triangleFieldExpected,triangleField,0);
    }

    @Test
    public void testGetCircleField() {
        ShapeCollector shapeCollector = new ShapeCollector();
        double circleField = shapeCollector.getShapeField(new Circle("circle", 5));

        double circleFieldExpected = 5*5*Math.PI;

        Assert.assertEquals(circleFieldExpected, circleField,0);
    }
}
