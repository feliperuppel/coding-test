package com.feliperuppel.fibonacci;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    private final List<BigInteger> sequence;

    Fibonacci() {
        this(0, 1);
    }

    Fibonacci(final long firstValue, final int secondValue) {
        sequence = new ArrayList<>();
        sequence.add(BigInteger.valueOf(firstValue));
        sequence.add(BigInteger.valueOf(secondValue));
    }

    public void increment() {
        final BigInteger lastItem = sequence.get(sequence.size() - 1);
        final BigInteger beforeLastItem = sequence.get(sequence.size() - 2);
        final BigInteger newItem = lastItem.add(beforeLastItem);
        sequence.add(newItem);
    }

    public BigInteger getValue(final int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Not Possible to calculate Fibonacci");
        }

        while (i >= sequence.size()) {
            increment();
        }
        return sequence.get(i);
    }

    @Override
    public String toString() {
        return "Fibonacci{ size="+ sequence.size() +" sequence=" + sequence + "}";
    }
}
