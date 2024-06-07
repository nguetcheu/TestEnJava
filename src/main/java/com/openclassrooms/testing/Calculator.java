package com.openclassrooms.testing;

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
}
