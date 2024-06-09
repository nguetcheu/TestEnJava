package com.openclassrooms.testing;

import java.util.HashSet;
import java.util.Set;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int soutraire(int a, int b) {
        return a - b;
    }

    public int divide(int a, int b) {
        try {
            return a / b;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public void longCalculation() {
        try {
            // Attendre 2 secondes
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Set<Integer> digitsSet(int number) {
        Set<Integer> digits = new HashSet<>();

        while (number > 0) {
            digits.add(number % 10);
            number /= 10;
        }

        return digits;
    }
}
