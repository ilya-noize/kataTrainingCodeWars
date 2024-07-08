package com.codewars.kata.training;

import org.junit.jupiter.api.Test;

import static com.codewars.kata.training.TenMinutesWalk.EAST;
import static com.codewars.kata.training.TenMinutesWalk.NORTH;
import static com.codewars.kata.training.TenMinutesWalk.SOUTH;
import static com.codewars.kata.training.TenMinutesWalk.WEST;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TenMinutesWalkTest {

    @Test
    void isValid() {
        char[] walk = {NORTH, EAST, SOUTH, WEST, SOUTH, WEST, NORTH, EAST, WEST, EAST};
        assertTrue(TenMinutesWalk.isValid(walk));
    }

    @Test
    void isNotValid() {
        char[] walk = {NORTH, EAST, SOUTH, WEST, SOUTH, WEST, NORTH, EAST, WEST, NORTH};
        assertFalse(TenMinutesWalk.isValid(walk));
    }

    @Test
    void Test() {
        assertTrue(TenMinutesWalk.isValid(new char[]{'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's'}));
        assertFalse(TenMinutesWalk.isValid(new char[]{'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e'}));
        assertFalse(TenMinutesWalk.isValid(new char[]{'w'}));
        assertFalse(TenMinutesWalk.isValid(new char[]{'n', 'n', 'n', 's', 'n', 's', 'n', 's', 'n', 's'}));
    }
}