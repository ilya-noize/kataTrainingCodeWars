package com.codewars.kata.training;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeFormatterTest {
    @Test
    @Order(1)
    void test1() {
        assertEquals("1 second", TimeFormatter.formatDuration(1));
    }

    @Test
    @Order(2)
    void Test62() {
        assertEquals("1 minute and 2 seconds", TimeFormatter.formatDuration(62));
    }

    @Test
    @Order(3)
    void test120() {
        assertEquals("2 minutes", TimeFormatter.formatDuration(120));
    }

    @Test
    @Order(4)
    void test3600() {
        assertEquals("1 hour", TimeFormatter.formatDuration(3600));
    }

    @Test
    @Order(5)
    void test3662() {
        assertEquals("1 hour, 1 minute and 2 seconds", TimeFormatter.formatDuration(3662));
    }

    @Test
    @Order(6)
    void test2962469() {
        assertEquals("34 days, 6 hours, 54 minutes and 29 seconds", TimeFormatter.formatDuration(2962469));
    }

    @Test
    @Order(7)
    void test2091120() {
        assertEquals("24 days, 4 hours and 52 minutes", TimeFormatter.formatDuration(2091120));
    }

    @Test
    @Order(8)
    void test0() {
        assertEquals("now", TimeFormatter.formatDuration(0));
    }
}