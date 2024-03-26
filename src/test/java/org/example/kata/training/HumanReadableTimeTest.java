package org.example.kata.training;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HumanReadableTimeTest {

    @Test
    void makeReadable0() {
        String message;
        message = HumanReadableTime.makeReadable(0);
        System.out.println("message = " + message);
        assertEquals("00:00:00", message);

        message = HumanReadableTime.makeReadable(5);
        System.out.println("message = " + message);
        assertEquals("00:00:05", message);

        message = HumanReadableTime.makeReadable(60);
        System.out.println("message = " + message);
        assertEquals("00:01:00", message);

        message = HumanReadableTime.makeReadable(86399);
        System.out.println("message = " + message);
        assertEquals("23:59:59", message);

        message = HumanReadableTime.makeReadable(359999);
        System.out.println("message = " + message);
        assertEquals("99:59:59", message);
    }


    @Test
    void makeReadable360000() {
        try {
            HumanReadableTime.makeReadable(360000);
        } catch (RuntimeException e) {
            assertEquals("Field overflow error", e.getMessage());
        }
    }
}