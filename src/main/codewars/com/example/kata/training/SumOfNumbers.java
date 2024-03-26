package com.example.kata.training;

/**
 * Given two integers a and b, which can be positive or negative,
 * find the sum of all the integers between and including them and return it.
 * If the two numbers are equal return a or b.
 * <p>
 * Note: a and b are not ordered!
 */
public class SumOfNumbers {
    private SumOfNumbers() {
    }

    public static int getSum(int a, int b) {
        if (a == b) return a;
        if (a + 1 == b || a == b + 1) return a + b;

        int i;
        if (a > b) {
            i = a;
            a = b;
            b = i;

        }
        int sum = a;
        for (i = a + 1; i <= b; i++) {
            sum += i;
        }
        return sum;
    }
}
