package com.codewars.kata.training;

public class MatrixOperations {

    private MatrixOperations() {
    }

    /*
     * matrixAddition(
     * [ [1, 2, 3],           [ [2, 2, 1],            [ [1+2, 2+2, 3+1],
     *   [3, 2, 1],     +       [3, 2, 3],              [3+3, 2+2, 1+3],
     *   [1, 1, 1] ],           [1, 1, 3] ] )           [1+1, 1+1, 1+3] ] )
     *
     * returns:
     * [ [3, 4, 4],
     *   [6, 4, 4],
     *   [2, 2, 4] ]
     */
    public static int[][] matrixAddition(int[][] a, int[][] b) {
        int minRows = Math.min(a.length, b.length);
        int minColumns = Math.min(a[0].length, b[0].length);
        int[][] c = new int[minRows][minColumns];
        for (int i = 0; i < minRows; i++) {
            for (int j = 0; j < minColumns; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        return c;
    }
}
