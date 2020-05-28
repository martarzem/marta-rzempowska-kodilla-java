package com.kodilla.patterns2.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class ShopService {
    private final List<Order> orders = new ArrayList<>();
    @Autowired
    private Authenticator authenticator;
    @Autowired
    private ProductService productService;

    //tworzy nowe zamówienie dla użytkownika
    public Long openOrder(Long userId) {
        if (authenticator.isAuthenticated(userId)) { //sprawdza, czy user jest zautoryzowany
            Long maxOrder = (long)orders.stream()
                    .mapToInt(o -> o.getOrderId().intValue())
                    .max().orElse(0);
            orders.add(new Order(maxOrder + 1, userId, productService)); //tworzenie obiektu zamówienia i dodanie go do kolekcji orders
            return maxOrder + 1; //jeśli jest zautoryzowany, zwraca id utworzonego zamówienia
        } else {
            return  -1L; //jeśli user nie jest zautoryzowany
        }
    }

    //dodaje pozycję do utworzonego zamówienia
    public void addItem(long orderId, Long productId, double qty) {
        orders.stream()
                .filter(o -> o.getOrderId().equals(orderId)) //wyszukuje zamówienie o podanym id
                .forEach(o -> o.getItems().add(new Item(productId, qty))); //dodaje Item do znalezionego zamówienia
    }

    public boolean removeItem(Long orderId, Long productId) {
        Iterator<Order> orderIterator = orders.stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .iterator();
        while (orderIterator.hasNext()) { //czy są jeszcze elementy w kolekcji
            Order theOrder = orderIterator.next(); //zwraca kolejny element
            int orderSize = theOrder.getItems().size();
            for (int n = 0; n < orderSize; n++) {
                if (theOrder.getItems().get(n).getProductId().equals(productId)) {
                    theOrder.getItems().remove(n);
                    return true;
                }
            }
        }
        return false; //jeśli zamówienie o takim id lub produkt o takim id nie zostały znalezione
    }

    // oblicza wartość zamówienia do zapłaty
    public BigDecimal calculateValue(Long orderId) {
        Iterator<Order> orderIterator = orders.stream()
                .filter(o -> o.getOrderId().equals(orderId)) //szukamy zamówienia o podanym id
                .iterator(); //tworzony jest iterator na liście wynikowej
        while (orderIterator.hasNext()) {
            Order theOrder = orderIterator.next();
            return theOrder.calculateValue();
        }
        return BigDecimal.ZERO;
    }

    // dokonuje płatności za zamówienie
    public boolean doPayment(Long orderId) {
        Iterator<Order> orderIterator = orders.stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .iterator();
        while (orderIterator.hasNext()) {
            Order theOrder = orderIterator.next();
            if (theOrder.isPaid()) {
                return true;
            } else {
                Random generator = new Random();
                theOrder.setPaid(generator.nextBoolean()); //losowo czy udało się przeprowadzić płatność + ustawienie  wartości pola
                return theOrder.isPaid();
            }
        }
        return false;
    }

    // weryfikacja zamówienia - czy płatność zostałą dokonana i czy formalne warunki zamówienia zostały spełnione
    public boolean verifyOrder(Long orderId) {
        Iterator<Order> orderIterator = orders.stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .iterator();
        while (orderIterator.hasNext()) {
            Order theOrder = orderIterator.next();
            boolean result = theOrder.isPaid();
            Random generator = new Random(); //losowo formalne warunki
            if (!theOrder.isVerified()) {
                theOrder.setVerified(result && generator.nextBoolean());
            }
            return theOrder.isVerified();
        }
        return false;
    }

    // zatwierdza zamówienie
    public boolean submitOrder(Long orderId) {
        Iterator<Order> orderIterator = orders.stream()
                .filter(o -> o.getOrderId().equals(orderId)) //odnajduje zamówienie
                .iterator();
        while (orderIterator.hasNext()) {
            Order theOrder = orderIterator.next();
            if (theOrder.isVerified()) { //sprawdza czy zostało pozytywnie zweryfikowane
                theOrder.setSubmitted(true);
            }
            return theOrder.isSubmitted();
        }
        return false;
    }

    // user ma możliwość anulowania zamówienia - usuwa z listy otwarte zamówienie
    public void cancelOrder(Long orderId) {
        Iterator<Order> orderIterator = orders.stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .iterator();
        while (orderIterator.hasNext()) {
            Order theOrder = orderIterator.next();
            orders.remove(theOrder);
        }
    }


}
