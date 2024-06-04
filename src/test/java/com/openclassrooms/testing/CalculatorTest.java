package com.openclassrooms.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void testAddTwoPositiveNumbers() {
        // arrange
        int a = 2;
        int b = 3;
        Calculator calculator = new Calculator();

        // Act
        int somme = calculator.add(a, b);

        // Assert
        assertEquals(5, somme);
    }
    
}
