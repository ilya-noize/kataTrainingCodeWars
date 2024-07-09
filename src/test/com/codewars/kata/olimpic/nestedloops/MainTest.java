package com.codewars.kata.olimpic.nestedloops;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.codewars.kata.olimpic.nestedloops.Main.DENOMINATOR;
import static com.codewars.kata.olimpic.nestedloops.Main.RangeCycle;
import static com.codewars.kata.olimpic.nestedloops.Main.RangeCycle.CycleParameter;
import static com.codewars.kata.olimpic.nestedloops.Main.runCyclesWithPreviousParametersCycles;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    /**
     * 3<br/>
     * 1 10<br/>
     * a 12<br/>
     * 5 b<br/>
     *
     * <p>325</p>
     */
    @Test
    void ExampleTest() {
        int result = 0;
        for (int a = 1; a <= 10; a++) {
            for (int b = a; b <= 12; b++) {
                for (int c = 5; c <= b; c++) {
                    result = (result + 1) % DENOMINATOR;
                }
            }
        }
        assertEquals(325, result);
    }

    @Test
    void AdvancedTest() {
        Map<Integer, RangeCycle> roadMapNestedLoops = new HashMap<>();

        roadMapNestedLoops.put(
                0, new RangeCycle(
                        new CycleParameter(1),
                        new CycleParameter(10))
        );
        roadMapNestedLoops.put(
                1, new RangeCycle(
                        new CycleParameter('a'),
                        new CycleParameter(12))
        );
        roadMapNestedLoops.put(
                2, new RangeCycle(
                        new CycleParameter(5),
                        new CycleParameter('b'))
        );

        int countNestedLoops = roadMapNestedLoops.size();

        int[] valuePreviousCycles = new int[countNestedLoops];

        int result = runCyclesWithPreviousParametersCycles(
                roadMapNestedLoops,
                valuePreviousCycles,
                0,
                countNestedLoops,
                0
        );

        assertEquals(325, result);
    }
}