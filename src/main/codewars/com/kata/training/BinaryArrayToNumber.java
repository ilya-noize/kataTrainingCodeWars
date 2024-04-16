package codewars.com.kata.training;

import java.util.List;

/**
 *
 */
public class BinaryArrayToNumber {
    private BinaryArrayToNumber() {
    }

    public static long convertBinaryArrayToInt(List<Integer> binary) {
        long result = 0L;
        int last = binary.size() - 1;
        for (int i = last; i >= 0; i--) {
            if (binary.get(i).equals(1)) {
                result += Math.pow(2, (last - i));
            }
        }
        return result;
    }
}
