package com.codewars.kata.training;

/**
 * A Narcissistic Number (or Armstrong Number) is a positive number which is the sum of its own digits,
 * each raised to the power of the number of digits in a given base.
 */
public class ArmstrongNumber {

    private ArmstrongNumber() {
    }

    public static boolean isNarcissistic(int number) {
        String string = String.valueOf(number);
        int length = string.length();
        int sumPower = 0;
        int digit;
        for (int i = 0; i < length; i++) {
            digit = Integer.parseInt(string.substring(i, i + 1));
            sumPower += Math.pow(digit, length);
        }
        return sumPower == number;
    }
}
