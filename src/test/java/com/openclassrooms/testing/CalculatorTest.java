package com.openclassrooms.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void testAddTwoPositiveNumbers() {
        // Arrange
        int a = 2;
        int b = 3;
        Calculator calculator = new Calculator();

        // Act
        int somme = calculator.add(a, b);

        // Assert
        assertEquals(5, somme);
    }

    @Test
    void multiplyTwoPositiveNumbers() {
        // Arrange
        int a = 3;
        int b = 5;
        Calculator calculator = new Calculator();

        // Act
        int multplication = calculator.multiply(a,b);

        // Assert
        assertEquals(15, multplication);
    }
}
