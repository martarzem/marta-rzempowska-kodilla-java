package com.kodilla.patterns2.facade;

import org.springframework.stereotype.Service;

import java.util.Random;

//sprawdzanie, czy user jest zautoryzowany - u nas losowo przydzielana autoryzacja
@Service
public class Authenticator {
    public boolean isAuthenticated(Long userId) {
        Random random = new Random();
        return random.nextBoolean(); //losowanie wartości logicznej
    }
}
