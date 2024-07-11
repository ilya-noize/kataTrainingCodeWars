package com.codewars.kata.training;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeMathTest {
    @Test
    void add()
    {
        assertEquals("03:40:36", TimeMath.timeMath("01:24:31", "+", "02:16:05"));
        assertEquals("23:59:59", TimeMath.timeMath("01:24:31", "+", "22:35:28"));
        assertEquals("00:00:00", TimeMath.timeMath("23:59:59", "+", "00:00:01"));
    }
    @Test
    void subtract()
    {
        assertEquals("00:00:00", TimeMath.timeMath("11:24:31", "-", "11:24:31"));
        assertEquals("08:09:03", TimeMath.timeMath("11:24:31", "-", "03:15:28"));
    }
}