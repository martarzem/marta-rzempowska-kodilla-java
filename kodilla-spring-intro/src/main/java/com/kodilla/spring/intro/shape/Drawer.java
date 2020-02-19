package com.kodilla.spring.intro.shape;

public class Drawer {

        /* WERSJA WYJŚCIOWA
        public void doDrawing() {
        Circle circle = new Circle();
        Triangle triangle = new Triangle();

        circle.draw();
        triangle.draw();
         */

        /*
        //WPROWADZAMY POLIMORFIZM DO KLASY DRAWER
        //public void doDrawing() {
        Figure figure; //zmienna figure jest typu ogólnego, nadrzędnego

        figure = new Circle(); //przypisujemy do zmiennej obiekty typów potomnych
        figure.draw(); //wywoływana jest metoda odpowiednia dla typu przypisanego (nie ta z klasy Figure)

        figure = new Triangle();
        figure.draw();
    }
         */

        /*
        // WERSJA DLA KORZYSTANIA Z INTERFEJSU SHAPE
        public void doDrawing() {
            Shape shape;

            shape = new Circle();
            shape.draw();

            shape = new Triangle();
            shape.draw();
        }
         */

    //WYCIĄGAMY ZALEŻNOŚCI POZA KLASĘ
    final Shape shape;

    public Drawer(final Shape shape) {
        this.shape = shape;
    }

    public String doDrawing() {
        return shape.draw();
    }
}
