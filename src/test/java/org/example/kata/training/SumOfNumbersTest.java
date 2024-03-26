package org.example.kata.training;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumOfNumbersTest {
    @Test
    void getSum() {
        assertEquals(-120, SumOfNumbers.getSum(0, -15));
        assertEquals(105, SumOfNumbers.getSum(0, 14));
    }
}