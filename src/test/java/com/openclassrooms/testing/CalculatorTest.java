package com.openclassrooms.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

public class CalculatorTest {

    private static Instant startedAt;

    private Calculator calculatorUnderTest;

    @BeforeEach
    public void initCalculator() {
        System.out.println("Avant chaque test ");
        calculatorUnderTest = new Calculator();
    }

    @AfterEach
    public void undefCalculator(){
        System.out.println("Apres chaque test");
        calculatorUnderTest = null;
    }

    @BeforeAll
    static public void initStartingTime() {
        System.out.println("Appel avant tout les tests");
        startedAt = Instant.now();
    }

    @AfterAll
    static public void showTestDuration() {
        System.out.println("Appel après tout les tests");
        Instant endedAt = Instant.now();
        long duration = Duration.between(startedAt, endedAt).toMillis();
        System.out.println(MessageFormat.format("Durée des test : {0} ms", duration));
    }

    @Test
    void testAddTwoPositiveNumbers() {
        // Arrange
        int a = 2;
        int b = 3;

        // Act
        int somme = calculatorUnderTest.add(a, b);

        // Assert
        assertEquals(5, somme);
    }

    @Test
    void multiplyTwoPositiveNumbers() {
        // Arrange
        int a = 3;
        int b = 5;

        // Act
        int multplication = calculatorUnderTest.multiply(a,b);

        // Assert
        assertEquals(15, multplication);
    }

    @Test
    void soustraireTwoPositiveNumber() {
        // Arrange
        int a = 5;
        int b = 6;

        // Act
        int soustraction = calculatorUnderTest.soutraire(a, b);

        // Assert
        assertEquals(-1, soustraction);
    }

    @Test
    void divideNumberAndThrowException() {
        //Arrange
        int a = 10;
        int b = 0;

        // Act
        int divide = calculatorUnderTest.divide(a,b);

        // Assert
        assertEquals(0, divide);
    }
}
