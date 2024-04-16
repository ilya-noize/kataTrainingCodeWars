package codewars.com;

import codewars.com.kata.training.Accumul;
import codewars.com.kata.training.BraceChecker;
import codewars.com.kata.training.SplitStrings;
import codewars.com.kata.training.SumOfNumbers;
import codewars.com.kata.training.ArmstrongNumber;
import codewars.com.kata.training.BinaryArrayToNumber;
import codewars.com.kata.training.ConvertStringToCamelCase;
import codewars.com.kata.training.HumanReadableTime;
import codewars.com.kata.training.PhoneNumber;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String string = "Hello world!";
        String regex = "[^a-zA-Zа-яА-Я]+";
        String convertStringToCamelCase = ConvertStringToCamelCase.solution(string, regex);
        System.out.println("convertStringToCamelCase = " + convertStringToCamelCase);

        String[] splitStrings = SplitStrings.solution(convertStringToCamelCase);
        System.out.println("splitStrings = " + Arrays.toString(splitStrings));

        int number = 153;
        boolean armstrongNumber = ArmstrongNumber.isNarcissistic(number);
        System.out.println("armstrongNumber = " + armstrongNumber);

        int a = -1;
        int b = 2;
        int sumOfNumbers = SumOfNumbers.getSum(a, b);
        System.out.println("sumOfNumbers = " + sumOfNumbers);

        String accum = Accumul.accum(convertStringToCamelCase);
        System.out.println("accum = " + accum);

        List<Integer> binary = List.of(1,1,1,1);
        long convertBinaryArrayToInt = BinaryArrayToNumber.convertBinaryArrayToInt(binary);
        System.out.println("convertBinaryArrayToInt = " + convertBinaryArrayToInt);


        System.out.println("PhoneNumber");
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String phoneNumber = PhoneNumber.createPhoneNumber(numbers);
        System.out.println("phoneNumber = " + phoneNumber);


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

        System.out.println("BraceChecker");
        String braces = "())({}}{()][][";
        System.out.println("string = " + braces);
        BraceChecker braceChecker = new BraceChecker();
        System.out.println("result = " + braceChecker.isValid(braces));

    }
}