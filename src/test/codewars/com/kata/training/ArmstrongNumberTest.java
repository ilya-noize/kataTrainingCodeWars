package codewars.com.kata.training;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArmstrongNumberTest {

    @Test
    void exampleTests() {
        assertTrue(ArmstrongNumber.isNarcissistic(153), "153 is narcissistic");
        assertTrue(ArmstrongNumber.isNarcissistic(1634), "1634 is narcissistic");
        assertFalse(ArmstrongNumber.isNarcissistic(112), "112 is not narcissistic");
    }
}