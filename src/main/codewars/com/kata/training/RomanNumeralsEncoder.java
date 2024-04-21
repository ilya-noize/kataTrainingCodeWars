package codewars.com.kata.training;

import java.util.Map;

public class RomanNumeralsEncoder {
    private final Map<Integer, Map<Integer, String>> roman = Map.of(
            1, Map.of(
                    1, "I",
                    2, "I".repeat(2),
                    3, "I".repeat(3),
                    4, "IV",
                    5, "V",
                    6, "VI",
                    7, "VII",
                    8, "VIII",
                    9, "IX"
            ),
            2, Map.of(
                    1, "X",
                    2, "X".repeat(2),
                    3, "X".repeat(3),
                    4, "XL",
                    5, "L",
                    6, "LX",
                    7, "LXX",
                    8, "LXXX",
                    9, "XC"
            ),
            3, Map.of(
                    1, "C",
                    2, "C".repeat(2),
                    3, "C".repeat(3),
                    4, "CD",
                    5, "D",
                    6, "DC",
                    7, "DCC",
                    8, "DCCC",
                    9, "CM"
            ),
            4, Map.of(
                    1, "M",
                    2, "M".repeat(2),
                    3, "M".repeat(3),
                    4, "M".repeat(4),
                    5, "M".repeat(5),
                    6, "M".repeat(6),
                    7, "M".repeat(7),
                    8, "M".repeat(8),
                    9, "M".repeat(9)
            )
    );

    public String solution(int n) {
        StringBuilder out = new StringBuilder();
        String num = Integer.toString(n);
        int length = num.length();
        for (int i = 0; i < length; i++) {
            String digit = num.substring(i, i + 1);
            String str = roman.get(length - i).get(Integer.parseInt(digit));
            if (str != null) out.append(str);
        }
        return out.toString();
    }
}
