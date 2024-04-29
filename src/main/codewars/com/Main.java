package codewars.com;

import codewars.com.kata.training.Accumul;
import codewars.com.kata.training.ArmstrongNumber;
import codewars.com.kata.training.BinaryArrayToNumber;
import codewars.com.kata.training.BraceChecker;
import codewars.com.kata.training.ConvertStringToCamelCase;
import codewars.com.kata.training.HumanReadableTime;
import codewars.com.kata.training.PhoneNumber;
import codewars.com.kata.training.RomanNumeralsEncoder;
import codewars.com.kata.training.SplitStrings;
import codewars.com.kata.training.SumOfNumbers;
import codewars.com.kata.training.TimeFormatter;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        timeFormatter();
        kataPack();
    }

    private static void timeFormatter() {
        System.out.println("Time Formatter - human friendly format");
        System.out.println(TimeFormatter.formatDuration(1));
        System.out.println(TimeFormatter.formatDuration(61));
        System.out.println(TimeFormatter.formatDuration(3601));
        System.out.println(TimeFormatter.formatDuration(86401));
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
        List<Integer> binary = List.of(1,1,1,1);
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
        String string = "Hello world!";
        String regex = "[^a-zA-Zа-яА-Я]+";
        String convertStringToCamelCase = ConvertStringToCamelCase.solution(string, regex);
        System.out.println("convertStringToCamelCase = " + convertStringToCamelCase);
        return convertStringToCamelCase;
    }
}