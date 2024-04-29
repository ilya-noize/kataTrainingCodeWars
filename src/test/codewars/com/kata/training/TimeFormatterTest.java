package codewars.com.kata.training;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeFormatterTest {
    @Test
    void test1() {
        assertEquals("1 second", TimeFormatter.formatDuration(1));
    }

    @Test
    void Test62() {
        assertEquals("1 minute and 2 seconds", TimeFormatter.formatDuration(62));
    }

    @Test
    void test120() {
        assertEquals("2 minutes", TimeFormatter.formatDuration(120));
    }

    @Test
    void test3600() {
        assertEquals("1 hour", TimeFormatter.formatDuration(3600));
    }

    @Test
    void test3662() {
        assertEquals("1 hour, 1 minute and 2 seconds", TimeFormatter.formatDuration(3662));
    }

    @Test
    void test2962469() {
        assertEquals("34 days, 6 hours, 54 minutes and 29 seconds", TimeFormatter.formatDuration(2962469));
    }

    @Test
    void test2091120() {
        assertEquals("34 days, 6 hours, 54 minutes and 29 seconds", TimeFormatter.formatDuration(2091120));
    }
}