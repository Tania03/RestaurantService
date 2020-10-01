package com.practice;

/**
 * @author tania.gupta
 * @date 17/07/20
 */

//2 1 0 2 1
//1 0 1 0 1
//1 0 0 2 1
public class RottenOranges {

    public static void main(String[] args) {

        int matrix[][] = new int[][]{{2, 1, 0, 2, 1}, {1, 0, 2, 0, 1}, {1, 0, 0, 2, 1}};
        RottenOranges rottenOranges = new RottenOranges();
        System.out.println(rottenOranges.findRottenCount(matrix));
    }

    public int updatedOneCount = 0;

    public int findRottenCount(int[][] matrix) {

        int attempts = 0;
        boolean oneLeft = true;

        while (oneLeft) {

            updatedOneCount = 0;
            for (int i = 0; i < matrix.length; i++) {

                for (int j = 0; j < matrix[0].length; j++) {

                    if (matrix[i][j] == 2) {
                        updateNeighbours(i, j, matrix);
                    }
                }
            }

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 3)
                        matrix[i][j] = 2;
                }
            }

            if (updatedOneCount > 0)
                attempts++;
            if (updatedOneCount == 0)
                oneLeft = false;

        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1)
                    return -1;
            }
        }

        return attempts;

    }

    private void updateNeighbours(int i, int j, int[][] matrix) {

        if (i > 0 && matrix[i - 1][j] == 1) {
            matrix[i - 1][j] = 3;
            updatedOneCount++;
        }

        if (i < matrix.length - 1 && matrix[i + 1][j] == 1) {
            matrix[i + 1][j] = 3;
            updatedOneCount++;
        }

        if (j > 0 && matrix[i][j - 1] == 1) {
            matrix[i][j - 1] = 3;
            updatedOneCount++;
        }

        if (j < matrix[0].length - 1 && matrix[i][j + 1] == 1) {
            matrix[i][j + 1] = 3;
            updatedOneCount++;
        }
    }

}
