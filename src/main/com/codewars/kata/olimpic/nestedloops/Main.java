package com.codewars.kata.olimpic.nestedloops;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * INPUT    <br/>
 * 3        <br/>
 * 1 10     <br/>
 * a 12     <br/>
 * 5 b      <br/>
 * <p>
 * OUTPUT   <br/>
 * 325
 */
public class Main {
    public static final int LOOP_MAX = 26;
    public static final int LOOP_MIN = 1;
    public static final int DENOMINATOR = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String inputN = reader.readLine();
        int nestedLoops = Integer.parseInt(inputN);
        if (nestedLoops < LOOP_MIN || nestedLoops > LOOP_MAX) {
            throw new Main.NestedLoopException("Nested Loops over the limit.");
        }

        Map<Integer, RangeCycle> roadMapNestedLoops = new HashMap<>();

        for (int loop = 0; loop < nestedLoops; loop++) {
            String inputLoopBoundaries = reader.readLine();
            String[] loopBoundaries = inputLoopBoundaries.trim().split(" ");

            RangeCycle rangeCycle = getRangeCycle(loopBoundaries);
            roadMapNestedLoops.put(loop, rangeCycle);
        }

        int countNestedLoops = roadMapNestedLoops.size();

        int[] valuePreviousCycles = new int[countNestedLoops];

        int result = runCyclesWithPreviousParametersCycles(
                roadMapNestedLoops,
                valuePreviousCycles,
                0,
                countNestedLoops,
                0
        );

        writer.write(result + "\n");

        reader.close();
        writer.close();
    }

    private static RangeCycle getRangeCycle(String[] loopBoundaries) {
        Main.RangeCycle.CycleParameter initialCycleParameter =
                getCycleParameter(loopBoundaries[0]);
        Main.RangeCycle.CycleParameter finalCycleParameter =
                getCycleParameter(loopBoundaries[1]);

        return new RangeCycle(initialCycleParameter, finalCycleParameter);
    }

    private static Main.RangeCycle.CycleParameter getCycleParameter(String string) {
        char parameterName = string.charAt(0);
        if (Main.RangeCycle.CycleParameter.ALPHABET.contains(parameterName)) {

            return new Main.RangeCycle.CycleParameter(parameterName);
        } else {
            int value = Integer.parseInt(string);
            if (value > Main.RangeCycle.CycleParameter.LIMIT) {
                throw new Main.NestedLoopException("Lift or Raise Loop over the limit.");
            }
            return new Main.RangeCycle.CycleParameter(value);
        }
    }

    public static int runCyclesWithPreviousParametersCycles(
            Map<Integer, RangeCycle> roadMapNestedLoops,
            int[] valuePreviousCycles,
            Integer loop,
            int countNestedLoops,
            int result
    ) {
        RangeCycle rangeCycle = roadMapNestedLoops.get(loop);

        int initialValue = rangeCycle.getRangeTypeInLoopWithPreviousCyclesParameters(
                Main.RangeType.INITIAL,
                loop,
                valuePreviousCycles
        );
        int finalValue = rangeCycle.getRangeTypeInLoopWithPreviousCyclesParameters(
                Main.RangeType.FINAL,
                loop,
                valuePreviousCycles
        );

        for (int i = initialValue; i <= finalValue; i++) {

            if (loop + 1 != countNestedLoops) {

                valuePreviousCycles[loop] = i;
                result = runCyclesWithPreviousParametersCycles(
                        roadMapNestedLoops,
                        valuePreviousCycles,
                        ++loop,
                        countNestedLoops,
                        result
                );
                loop--;
            }
            if (loop + 1 == countNestedLoops) {
                result = (result + 1) % DENOMINATOR;
            }
        }

        return result;
    }

    static class NestedLoopException extends RuntimeException {
        public NestedLoopException(String message) {
            super(message);
        }
    }

    enum RangeType {
        INITIAL,
        FINAL
    }

    static final class RangeCycle {
        public static final byte ASCII_CODE_FIRST_CHAR =
                (byte) (char) Main.RangeCycle.CycleParameter.ALPHABET.get(0);
        public static final String RANGE_CYCLE_VALUE_NULL = "RangeType Cycle Value — null.";

        private final CycleParameter initialValue;
        private final CycleParameter finalValue;

        public RangeCycle(CycleParameter initialValue, CycleParameter finalValue) {
            this.initialValue = initialValue;
            this.finalValue = finalValue;
        }

        public CycleParameter getInitialValue() {
            return initialValue;
        }

        public CycleParameter getFinalValue() {
            return finalValue;
        }

        public int getRangeTypeInLoopWithPreviousCyclesParameters(
                RangeType rangeType,
                int loop,
                int[] parameters
        ) {

            CycleParameter cycleParameter = getCycleParameter(rangeType);
            Integer value = cycleParameter.getValue();
            Character param = cycleParameter.getParameterName();

            if (loop != 0) {
                if (param == null) {
                    if (value == null) {
                        throw new NullPointerException(RANGE_CYCLE_VALUE_NULL);
                    }

                    return value;
                }

                byte indexParameter = (byte) (param - ASCII_CODE_FIRST_CHAR);
                int lift = parameters[indexParameter];
                if (lift == 0) {
                    throw new NullPointerException("Parameter — null.");
                }

                return lift;
            }
            if (value == null) {
                throw new NullPointerException(RANGE_CYCLE_VALUE_NULL);
            }

            return value;
        }

        private CycleParameter getCycleParameter(RangeType rangeType) {
            if (rangeType == RangeType.INITIAL) {

                return getInitialValue();
            }

            return getFinalValue();
        }

        static final class CycleParameter {
            public static final List<Character> ALPHABET = List.of(
                    'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                    'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
            public static final int LIMIT = 100_000;
            private Character parameterName;
            private Integer value;

            public CycleParameter(Character parameterName) {
                if (!ALPHABET.contains(parameterName)) {
                    char first = ALPHABET.get(0);
                    char last = ALPHABET.get(ALPHABET.size() - 1);
                    System.out.println("Must be [" + first + " — " + last + "] character.");
                    return;
                }
                this.parameterName = parameterName;
            }

            public CycleParameter(Integer value) {
                this.value = value;
            }

            public Character getParameterName() {

                return parameterName;
            }

            public Integer getValue() {

                return value;
            }


        }
    }
}
