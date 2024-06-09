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
import java.util.Set;

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
    @Tag("QuatreOperations") // ce test fait partie des 4 opérations de base
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
    @Tag("QuatreOperations") // ce test fait partie des 4 opérations de base
    @DisplayName("Multiplication de deux nombres")
    void multiplyTwoPositiveNumbers() {
        // Arrange
        int a = 3;
        int b = 5;

        // Act
        int multiplication = calculatorUnderTest.multiply(a,b);

        // Assert
        assertThat(multiplication).isEqualTo(15);
    }



    @Test
    void soustraireTwoPositiveNumber() {
        // Arrange
        int a = 5;
        int b = 6;

        // Act
        int soustraction = calculatorUnderTest.soutraire(a, b);

        // Assert
        assertThat(soustraction).isEqualTo(-1);
    }

    @Test
    void divideNumberAndThrowException() {
        //Arrange
        int a = 10;
        int b = 0;

        // Act
        int divide = calculatorUnderTest.divide(a,b);

        // Assert
        assertThat(0).isEqualTo(divide);
    }

    @ParameterizedTest(name = "{0} x 0 doit être égal à 0")
    @ValueSource(ints = { 1, 2, 42, 1011, 5089 })
    public void multiply_shouldReturnZero_ofZeroWithMultipleIntegers(int arg) {
        // Arrange -- Tout est prêt !

        // Act -- Multiplier par zéro
        int actualResult = calculatorUnderTest.multiply(arg, 0);

        // Assert -- ça vaut toujours zéro !
        assertThat(0).isEqualTo(actualResult);
    }

    @ParameterizedTest(name = "{0} + {1} should equal to {2}")
    @CsvSource({ "1,1,2", "2,3,5", "42,57,99"})
    public void add_shouldReturnTheSum_ofMultipleIntegers(int arg1, int arg2, int expectResult) {
        // Arrange -- Tout est prêt !

        // Act
        int actualResult = calculatorUnderTest.add(arg1, arg2);

        // Assert
        assertThat(expectResult).isEqualTo(actualResult);
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

    @Test
    public void listDigits_shouldReturnsTheListOfDigits_ofPositiveInteger() {
        // GIVEN
        int number = 95897;

        // WHEN
        Set<Integer> actualDigits = calculatorUnderTest.digitsSet(number);

        // THEN
        assertThat(actualDigits).containsExactlyInAnyOrder(5, 7, 8, 9);
    }


}
