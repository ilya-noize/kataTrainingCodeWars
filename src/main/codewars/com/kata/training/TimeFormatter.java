package codewars.com.kata.training;

/**
 * Your task in order to complete this Kata is to write a function which formats a duration, given as a number of seconds, in a human-friendly way.
 * <p>
 * The function must accept a non-negative integer. If it is zero, it just returns "now". Otherwise, the duration is expressed as a combination of years, days, hours, minutes and seconds.
 * <p>
 * It is much easier to understand with an example:
 * <p>
 * For seconds = 62, your function should return
 * "1 minute and 2 seconds"
 * For seconds = 3662, your function should return
 * "1 hour, 1 minute and 2 seconds"
 */

enum Time {
    DAY_PER_YEAR(365),
    HOURS_PER_DAY(24),
    MINUTES_PER_HOUR(60),
    SECONDS_PER_MINUTE(60);

    private final int value;

    Time(int value) {
        this.value = value;
    }

    public static int getSecondsPerMinute() {
        return SECONDS_PER_MINUTE.value;
    }

    public static int getSecondsPerHour() {
        return SECONDS_PER_MINUTE.value * MINUTES_PER_HOUR.value;
    }

    public static int getSecondsPerDay() {
        return getSecondsPerHour() * HOURS_PER_DAY.value;
    }

    public static int getSecondsPerYear() {
        return getSecondsPerDay() * DAY_PER_YEAR.value;
    }
}

enum ConverterTimes {
    // Singular
    YEAR("year"),
    DAY("day"),
    HOUR("hour"),
    MINUTE("minute"),
    SECOND("second"),

    // Plural
    YEARS("years"),
    DAYS("days"),
    HOURS("hours"),
    MINUTES("minutes"),
    SECONDS("seconds");

    private final String naming;


    ConverterTimes(String naming) {
        this.naming = naming;
    }

    public static String getYear() {
        return YEAR.naming;
    }

    public static String getYears() {
        return YEARS.naming;
    }

    public static String getDay() {
        return DAY.naming;
    }

    public static String getDays() {
        return DAYS.naming;
    }

    public static String getHour() {
        return HOUR.naming;
    }

    public static String getHours() {
        return HOURS.naming;
    }

    public static String getMinute() {
        return MINUTE.naming;
    }

    public static String getMinutes() {
        return MINUTES.naming;
    }

    public static String getSecond() {
        return SECOND.naming;
    }

    public static String getSeconds() {
        return SECONDS.naming;
    }
}

public class TimeFormatter {

    private TimeFormatter() {
    }

    public static String formatDuration(int time) {
        System.out.println("time = " + time);
        int[] timeline = new int[5];
        /*years*/
        timeline[0] = time / Time.getSecondsPerYear();
        /*days*/
        timeline[1] = time % Time.getSecondsPerYear() / Time.getSecondsPerDay();
        /*hours*/
        timeline[2] = time % Time.getSecondsPerDay() / Time.getSecondsPerHour();
        /*minutes*/
        timeline[3] = time % Time.getSecondsPerHour() / Time.getSecondsPerMinute();
        /*seconds*/
        timeline[4] = time % Time.getSecondsPerMinute();

        return print(timeline).toString();
    }

    private static StringBuilder print(int[] timeline) {
        StringBuilder stringBuilder = new StringBuilder();
        int[] index = getLastNotZero(timeline);
        boolean isNow = true;
        for (int i = 0; i < timeline.length; i++) {
            int elementTime = timeline[i];
            if (elementTime != 0) {
                isNow = false;
                index[1]--;
                stringBuilder
                        .append(index[0] == i ? " and " : "")
                        .append(elementTime)
                        .append(" ")
                        .append(
                                elementTime == 1 ?
                                        getString(i, true) :
                                        getString(i, false)
                        )
                        .append(index[1] >= 2 ? ", " : "");
            }
        }
        if (isNow) {
            stringBuilder.append("now");
        }

        return stringBuilder;
    }

    private static int[] getLastNotZero(int[] timeline) {
        boolean isLast = false;
        int last = 0;
        int count = 1;
        int length = timeline.length - 1;
        for (int i = length; i >= 0; i--) {
            if (timeline[i] != 0) {
                if (!isLast) {
                    isLast = true;
                    last = i;
                } else {
                    count++;
                }
            } else {
                if (!isLast) {
                    last = length - i;
                }
            }
        }

        return new int[]{
                count != 1 ? last : -1,
                count
        };
    }

    private static String getString(int index, boolean isSingular) {
        if (index == 0) {
            return isSingular ? ConverterTimes.getYear() : ConverterTimes.getYears();
        } else if (index == 1) {
            return isSingular ? ConverterTimes.getDay() : ConverterTimes.getDays();
        } else if (index == 2) {
            return isSingular ? ConverterTimes.getHour() : ConverterTimes.getHours();
        } else if (index == 3) {
            return isSingular ? ConverterTimes.getMinute() : ConverterTimes.getMinutes();
        } else if (index == 4) {
            return isSingular ? ConverterTimes.getSecond() : ConverterTimes.getSeconds();
        }
        return null;
    }
}
