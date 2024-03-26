package codewars.com.example.kata.training;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PhoneNumberTest {

    @Test
    void createPhoneNumber() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        assertEquals("(123) 456-7890", PhoneNumber.createPhoneNumber(numbers));
    }
}