package org.example.kata.training;

public class Accumul {
    private Accumul() {
    }

    /**
     * accum("abcd") -> "A-Bb-Ccc-Dddd"
     * accum("RqaEzty") -> "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
     * accum("cwAt") -> "C-Ww-Aaa-Tttt"
     */
    public static String accum(String s) {
        s = s.toLowerCase().trim();
        int length = s.length();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            String symbol = s.substring(i, i + 1);
            builder.append(symbol.toUpperCase())
                    .append(i == 0 ? "" : symbol.repeat(i))
                    .append(i + 1 != length ? "-" : "");
        }
        return builder.toString();
    }
}
