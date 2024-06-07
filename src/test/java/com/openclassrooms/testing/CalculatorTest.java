package com.openclassrooms.testing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
        assertThat(somme).isEqualTo(5);
    }

    @Test
    void multiplyTwoPositiveNumbers() {
        // Arrange
        int a = 3;
        int b = 5;

        // Act
        int multiplication = calculatorUnderTest.multiply(a,b);

        // Assert
        assertEquals(15, multiplication);
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

    @ParameterizedTest(name = "{0} x 0 doit être égal à 0")
    @ValueSource(ints = { 1, 2, 42, 1011, 5089 })
    public void multiply_shouldReturnZero_ofZeroWithMultipleIntegers(int arg) {
        // Arrange -- Tout est prêt !

        // Act -- Multiplier par zéro
        int actualResult = calculatorUnderTest.multiply(arg, 0);

        // Assert -- ça vaut toujours zéro !
        assertEquals(0, actualResult);
    }

    @ParameterizedTest(name = "{0} + {1} should equal to {2}")
    @CsvSource({ "1,1,2", "2,3,5", "42,57,99"})
    public void add_shouldReturnTheSum_ofMultipleIntegers(int arg1, int arg2, int expectResult) {
        // Arrange -- Tout est prêt !

        // Act
        int actualResult = calculatorUnderTest.add(arg1, arg2);

        // Assert
        assertEquals(expectResult, actualResult);
    }

    @Timeout(1)
    @Test
    public void longCalcul_shouldComputeInLessThan1Second() {
        // Arrange

        // Act
        calculatorUnderTest.longCalculation();
        // Assert
        // ...
    }

}
