package com.example.kata.training;

import lombok.ToString;

@ToString
public class ConvertStringToCamelCase {

    private ConvertStringToCamelCase() {
    }

    public static String solution(String string, String regex) {
        String[] strings = string.split(regex);
        for (int i = 1; i < strings.length; i++) {
            String stringFromArray = strings[i];
            char firstSymbol = stringFromArray.charAt(0);
            strings[i] = Character.toUpperCase(firstSymbol)
                    + stringFromArray.substring(1);
        }
        return String.join("", strings);
    }
}
