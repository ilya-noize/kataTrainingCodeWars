package com.codewars.kata.training;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>ROT13 (Rotate13, "rotate by 13 places", sometimes hyphenated ROT-13)</b>
 * is a simple letter substitution cipher that replaces a letter with the 13th letter after it in the Latin alphabet.
 * <i>ROT13 is a special case of the Caesar cipher which was developed in ancient Rome.</i>
 * <p>
 * {@code (https://en.wikipedia.org/wiki/ROT13)}
 */
public class ROT13 {

    private ROT13() {
    }

    public static String rot13(String message) {
        Map<Character, Character> code = getCode();
        char[] chars = message.toCharArray();
        StringBuilder rotString = new StringBuilder();
        for (char c : chars) {
            if (code.containsKey(c)) {
                rotString.append(code.get(c));
            } else {
                rotString.append(c);
            }
        }
        return rotString.toString();
    }

    private static Map<Character, Character> getCode() {
        String input = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        char[] keys = input.toCharArray();

        String output = "NOPQRSTUVWXYZABCDEFGHIJKLMnopqrstuvwxyzabcdefghijklm";
        char[] values = output.toCharArray();

        Map<Character, Character> code = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            code.put(keys[i], values[i]);
        }

        return code;
    }
}
