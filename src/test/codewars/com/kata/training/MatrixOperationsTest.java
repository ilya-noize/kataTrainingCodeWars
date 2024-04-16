package codewars.com.kata.training;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixOperationsTest {

    @Test
    void matrixAddition() {
        int[][] expected = new int[][] { { 3, 4, 4 }, { 6, 4, 4 }, { 2, 2, 4 } };

        assertArrayEquals(expected,
                MatrixOperations.matrixAddition(
                        new int[][] { { 1, 2, 3 }, { 3, 2, 1 }, { 1, 1, 1 } },
                        new int[][] { { 2, 2, 1 }, { 3, 2, 3 }, { 1, 1, 3 } }));

        expected = new int[][] { { 3 } };
        assertArrayEquals(expected,
                MatrixOperations.matrixAddition(
                        new int[][] { { 1 } },
                        new int[][] { { 2 } }));

        expected = new int[][] { { 3, 5 }, { 3, 5 } };
        assertArrayEquals(expected,
                MatrixOperations.matrixAddition(
                        new int[][] { { 1, 2 }, { 1, 2 } },
                        new int[][] { { 2, 3 }, { 2, 3 } }));
    }
}