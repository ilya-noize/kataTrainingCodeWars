package com.codewars.kata.training;

import com.codewars.kata.training.exceptions.MyOwnRuntimeException;

/**
 * Write a function, which takes a non-negative integer (seconds) as input
 * and returns the time in a human-readable format (HH:MM:SS)
 * <ul>
 *     <li>HH = hours, padded to 2 digits, range: 00 - 99</li>
 *     <li>MM = minutes, padded to 2 digits, range: 00 - 59</li>
 *     <li>SS = seconds, padded to 2 digits, range: 00 - 59</li>
 * </ul>
 * The maximum time never exceeds 359999 (99:59:59)
 */
public class HumanReadableTime {
    private HumanReadableTime() {
    }

    public static String makeReadable(int seconds) {
        if (seconds > 359999) {
            throw new MyOwnRuntimeException("Field overflow error");
        }
        int hours = seconds / 3600;
        seconds -= 3600 * hours;
        int minutes = seconds / 60;
        seconds -= 60 * minutes;

        return String.format("%s:%s:%s",
                hours < 10 ? "0" + hours : hours + "",
                minutes < 10 ? "0" + minutes : minutes + "",
                seconds < 10 ? "0" + seconds : seconds + "");
    }

    public static String popularSolution(int seconds) {
        return String.format("%02d:%02d:%02d", seconds / 3600, (seconds / 60) % 60, seconds % 60);
    }

}
