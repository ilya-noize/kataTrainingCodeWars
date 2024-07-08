package com.codewars.kata.training;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;

/**
 * DESCRIPTION:
 * Given two times in hours, minutes, and seconds (ie '15:04:24'), add or subtract them.
 * This is a 24 hour clock.
 * Output should be two digits for all numbers: hours, minutes, seconds (ie '04:02:09').
 * <p>
 * timeMath('01:24:31', '+', '02:16:05') === '03:40:36'
 * <p>
 * timeMath('01:24:31', '-', '02:31:41') === '22:52:50'
 */
public class TimeMath {
    private static final int MAX_HOURS = 24;
    private static final int MAX_MINUTES = 60;
    private static final int MAX_SECONDS = 60;

    private static int second;
    private static int minute;
    private static int hour;

    private TimeMath() {
    }

    public static String timeMath(final String time1, final String op, final String time2) {
        int[] hours = new int[2];
        int[] minutes = new int[2];
        int[] seconds = new int[2];

        Map<Integer, String[]> times = new HashMap<>();
        times.put(0, time1.split(":"));
        times.put(1, time2.split(":"));
        times.keySet().forEach(key -> {
            hours[key] = parseInt(times.get(key)[0]);
            minutes[key] = parseInt(times.get(key)[1]);
            seconds[key] = parseInt(times.get(key)[2]);
        });
        if ("+".equals(op)) {
            second = seconds[0] + seconds[1];
            minute = second / MAX_SECONDS;
            second = getSeconds(second);

            minute += minutes[0] + minutes[1];
            hour = minute / MAX_MINUTES;
            minute = getMinutes(minute);

            hour += hours[0] + hours[1];
            hour = getHours(hour);
        } else if ("-".equals(op)) {
            second = seconds[0] - seconds[1];
            minute = second / MAX_SECONDS;
            if (second < 0) {
                second = MAX_SECONDS + second;
                --minute;
            }
            second = getSeconds(second);

            minute += minutes[0] - minutes[1];
            hour = minute / MAX_MINUTES;
            if (minute < 0) {
                minute = MAX_MINUTES + minute;
                --hour;
            }
            minute = getMinutes(minute);

            hour += hours[0] - hours[1];
            if (hour < 0) {
                hour = MAX_HOURS + hour;
            }
            hour = getHours(hour);
        }


        return (hour < 10 ? "0" + hour : hour) + ":"
                + (minute < 10 ? "0" + minute : minute) + ":"
                + (second < 10 ? "0" + second : second);
    }

    private static int getHours(int hours) {
        if (hours >= MAX_HOURS) {
            hours = hours % MAX_HOURS;
        }
        return hours;
    }

    private static int getMinutes(int minutes) {
        if (minutes >= MAX_MINUTES) {
            minutes = minutes % MAX_MINUTES;
        }
        return minutes;
    }

    private static int getSeconds(int seconds) {
        if (seconds >= MAX_SECONDS) {
            seconds = seconds % MAX_SECONDS;
        }
        return seconds;
    }
}