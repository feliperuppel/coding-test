package com.feliperuppel.fibonacci;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class FibonacciTest {

    @Test
    public void givenDefaultFibonacciSequenceWhenGet6ThenReturn8() {
        executeAndCompareResults(6, 8);
    }

    @Test
    public void givenDefaultFibonacciSequenceWhenGet8ThenReturn21() {
        executeAndCompareResults(8, 21);
    }

    @Test
    public void givenCustomFibonacciSequenceWhenGetValueThenCorrectCalculation() {
        executeAndCompareResults(new Fibonacci(-8, 5), 4, -1);
    }

    @Test
    public void whenGetWithNegativeNumbersThenThrowException() {
        final Fibonacci fibonacci = new Fibonacci();
        assertThrows(IllegalArgumentException.class, () -> fibonacci.getValue(-1));
    }

    @Test
    public void whenGetOnPreviousCalculatedValueThenShouldNotRecalculate() {
        final Fibonacci fibonacci = spy(new Fibonacci());

        executeAndCompareResults(fibonacci, 10, 55);
        verify(fibonacci, times(9)).increment();
        reset(fibonacci);

        executeAndCompareResults(fibonacci, 15, 610);
        verify(fibonacci, times(5)).increment();
        reset(fibonacci);

        executeAndCompareResults(fibonacci, 5, 5);
        verify(fibonacci, times(0)).increment();
    }

    @Test
    public void whenToStringThenReturnSequenceSizeAndElements(){
        final String actualValue = new Fibonacci().toString();
        final String expectedValue = "Fibonacci{ size=2 sequence=[0, 1]}";
        assertEquals(expectedValue, actualValue);
    }

    private void executeAndCompareResults(final int param, final int expectedValue) {
        executeAndCompareResults(new Fibonacci(), param, expectedValue);
    }

    private void executeAndCompareResults(final Fibonacci fibonacci, final int param, final int expectedValue) {
        final BigInteger actualValue = fibonacci.getValue(param);
        assertEquals(BigInteger.valueOf(expectedValue), actualValue);
    }

}
