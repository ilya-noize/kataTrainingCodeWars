package org.example;

import org.example.kata.training.Accumul;
import org.example.kata.training.ArmstrongNumber;
import org.example.kata.training.BinaryArrayToNumber;
import org.example.kata.training.ConvertStringToCamelCase;
import org.example.kata.training.HumanReadableTime;
import org.example.kata.training.PhoneNumber;
import org.example.kata.training.SplitStrings;
import org.example.kata.training.SumOfNumbers;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String string = "Hello world!";
        String regex = "[^a-zA-Zа-яА-Я]+";
        String convertStringToCamelCase = ConvertStringToCamelCase.solution(string, regex);
        System.out.println("convertStringToCamelCase = " + convertStringToCamelCase);

        String helloWorld = convertStringToCamelCase;
        String[] splitStrings = SplitStrings.solution(helloWorld);
        System.out.println("splitStrings = " + Arrays.toString(splitStrings));

        int number = 153;
        boolean armstrongNumber = ArmstrongNumber.isNarcissistic(number);
        System.out.println("armstrongNumber = " + armstrongNumber);

        int a = -1;
        int b = 2;
        int sumOfNumbers = SumOfNumbers.getSum(a, b);
        System.out.println("sumOfNumbers = " + sumOfNumbers);

        String accum = Accumul.accum(helloWorld);
        System.out.println("accum = " + accum);

        List<Integer> binary = List.of(1,1,1,1);
        long convertBinaryArrayToInt = BinaryArrayToNumber.convertBinaryArrayToInt(binary);
        System.out.println("convertBinaryArrayToInt = " + convertBinaryArrayToInt);


        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String phoneNumber = PhoneNumber.createPhoneNumber(numbers);
        System.out.println("phoneNumber = " + phoneNumber);


        String message = HumanReadableTime.makeReadable(0);
        String messageIs = "HumanReadableTime = ";
        System.out.println(messageIs + message);
        message = HumanReadableTime.makeReadable(60);
        System.out.println(messageIs + message);
        message = HumanReadableTime.makeReadable(86399);
        System.out.println(messageIs + message);
        message = HumanReadableTime.makeReadable(359999);
        System.out.println(messageIs + message);
    }
}