package com.example.kata.training;

public class PhoneNumber {

    public String createPhoneNumberByMask(int[] numbers) {
        String phoneNumber = "(xxx) xxx-xxxx";

        for (int i : numbers) {
            phoneNumber = phoneNumber.replaceFirst("x", Integer.toString(i));
        }

        return phoneNumber;
    }

    public static String createPhoneNumber(int[] numbers) {
        StringBuilder phoneNumber = new StringBuilder("(");
        for (int i = 0; i < numbers.length; i++) {
            if (i == 3) phoneNumber.append(") ");
            if (i == 6) phoneNumber.append("-");
            phoneNumber.append(numbers[i]);
        }
        return phoneNumber.toString();
    }
}
