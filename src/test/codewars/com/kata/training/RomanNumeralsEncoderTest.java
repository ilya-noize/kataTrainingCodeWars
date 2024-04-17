package codewars.com.kata.training;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanNumeralsEncoderTest {

    private final RomanNumeralsEncoder encoder = new RomanNumeralsEncoder();

    @Test
    void shouldConvertToRoman() {
        assertEquals("I", encoder.solution(1));
        assertEquals("IV", encoder.solution(4));
        assertEquals("VI", encoder.solution(6));
    }
}