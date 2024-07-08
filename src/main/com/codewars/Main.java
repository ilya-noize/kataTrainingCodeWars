package com.codewars;

import com.codewars.kata.training.Accumul;
import com.codewars.kata.training.ArmstrongNumber;
import com.codewars.kata.training.BinaryArrayToNumber;
import com.codewars.kata.training.BraceChecker;
import com.codewars.kata.training.ConvertStringToCamelCase;
import com.codewars.kata.training.HumanReadableTime;
import com.codewars.kata.training.PhoneNumber;
import com.codewars.kata.training.PigLatin;
import com.codewars.kata.training.RangeExtraction;
import com.codewars.kata.training.RomanNumeralsEncoder;
import com.codewars.kata.training.SplitStrings;
import com.codewars.kata.training.SumOfNumbers;
import com.codewars.kata.training.TimeFormatter;

import java.util.Arrays;
import java.util.List;

public class Main {
    private static final String HELLO_WORLD = "hello World!";

    public static void main(String[] args) {
//        floatNaN();

        rangeExtraction();
//        kataPack();
    }

    private static void floatNaN() {
        Float f1 = 0f;//Float.NaN;
        Float f2 = 0f;//Float.NaN;

        System.out.println("- - - HashCodes:");
        System.out.println("f1 = " + f1.hashCode());
        System.out.println("f2 = " + f2.hashCode());

        System.out.println("- - - Value");
        System.out.println("f1 = " + f1.floatValue());
        System.out.println("f2 = " + f2.floatValue());

        System.out.println("- - - toString");
        System.out.println("f1 = " + f1);
        System.out.println("f2 = " + f2);

        boolean case1 = f1 == f2; // false
        boolean case2 = f1.equals(f2); // true
        boolean case3 = 0f == 0f; // true
//        boolean case3 = Float.NaN == Float.NaN; // false
        System.out.println(case1 + " " + case2 + " " + case3);
    }

    private static void kataPack() {
        String convertStringToCamelCase = convertStringToCamelCase();
        splitString(convertStringToCamelCase);
        armstrongNumber();
        sumOfNumbers();
        accumulate(convertStringToCamelCase);
        convertBinaryArrayToInt();
        phoneNumber();
        humanReadableTime();
        braceChecker();
        romanNumeralEncoder();
        timeFormatter();
        pigLatin();
    }

    private static void rangeExtraction() {
        int[] array = new int[]{-10, -9, -8, -6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20};
        String rangeExtraction = RangeExtraction.getRange(array);
        System.out.println("rangeExtraction = " + rangeExtraction);
    }

    private static void pigLatin() {
        String pigIt = PigLatin.pigIt(HELLO_WORLD);
        System.out.println("pigIt = " + pigIt);
    }

    private static void timeFormatter() {
        System.out.println("Time Formatter - human friendly format");
        System.out.println(TimeFormatter.formatDuration(1));
        System.out.println(TimeFormatter.formatDuration(61));
        System.out.println(TimeFormatter.formatDuration(3601));
        System.out.println(TimeFormatter.formatDuration(86401));
    }

    private static void romanNumeralEncoder() {
        RomanNumeralsEncoder encoder = new RomanNumeralsEncoder();
        String romanNumerals = encoder.solution(2210);
        System.out.println("romanNumerals = " + romanNumerals);
    }

    private static void braceChecker() {
        System.out.println("BraceChecker");
        String braces = "())({}}{()][][";
        System.out.println("string = " + braces);
        BraceChecker braceChecker = new BraceChecker();
        System.out.println("result = " + braceChecker.isValid(braces));
    }

    private static void humanReadableTime() {
        System.out.println("HumanReadableTime");
        String messageIs = "time = ";
        String message = HumanReadableTime.makeReadable(0);
        System.out.println(messageIs + message);
        message = HumanReadableTime.makeReadable(60);
        System.out.println(messageIs + message);
        message = HumanReadableTime.makeReadable(86399);
        System.out.println(messageIs + message);
        message = HumanReadableTime.makeReadable(359999);
        System.out.println(messageIs + message);
    }

    private static void phoneNumber() {
        System.out.println("PhoneNumber");
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String phoneNumber = PhoneNumber.createPhoneNumber(numbers);
        System.out.println("phoneNumber = " + phoneNumber);
    }

    private static void convertBinaryArrayToInt() {
        List<Integer> binary = List.of(1, 1, 1, 1);
        long convertBinaryArrayToInt = BinaryArrayToNumber.convertBinaryArrayToInt(binary);
        System.out.println("convertBinaryArrayToInt = " + convertBinaryArrayToInt);
    }

    private static void accumulate(String convertStringToCamelCase) {
        String accum = Accumul.accum(convertStringToCamelCase);
        System.out.println("accum = " + accum);
    }

    private static void sumOfNumbers() {
        int a = -1;
        int b = 2;
        int sumOfNumbers = SumOfNumbers.getSum(a, b);
        System.out.println("sumOfNumbers = " + sumOfNumbers);
    }

    private static void armstrongNumber() {
        int number = 153;
        boolean armstrongNumber = ArmstrongNumber.isNarcissistic(number);
        System.out.println("armstrongNumber = " + armstrongNumber);
    }

    private static void splitString(String convertStringToCamelCase) {
        String[] splitStrings = SplitStrings.solution(convertStringToCamelCase);
        System.out.println("splitStrings = " + Arrays.toString(splitStrings));
    }

    private static String convertStringToCamelCase() {
        String regex = "[^a-zA-Zа-яА-Я]+";
        String convertStringToCamelCase = ConvertStringToCamelCase.solution(HELLO_WORLD, regex);
        System.out.println("convertStringToCamelCase = " + convertStringToCamelCase);
        return convertStringToCamelCase;
    }
}