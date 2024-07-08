package com.codewars.kata.training;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BraceCheckerTest {
    private final BraceChecker checker = new BraceChecker();

    @Test
    void testValid() {
        assertTrue(checker.isValid("()"));
        assertTrue(checker.isValid("([{}])"));
        assertTrue(checker.isValid("({})[({})]"));
        assertTrue(checker.isValid("(({{[[]]}}))"));
        assertTrue(checker.isValid("{}({})[]"));
    }

    @Test
    void testInvalid() {
        assertFalse(checker.isValid("[(])"));
        assertFalse(checker.isValid(")(}{]["));
        assertFalse(checker.isValid("())({}}{()][]["));
        assertFalse(checker.isValid("(((({{"));
    }
}