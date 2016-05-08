package com.akahuman.matrix;

/**
 * Created by akahuman on 5/5/16.
 */
public class PrintSpiral {

    private static void printSpiral(int[][] arr, int row, int col) {
        int startRow = 0, startCol = 0;
        int endRow = row - 1, endCol = col - 1;
        int i;

        /**
         * Keep track of the startRow, endRow and startCol, endCol that has been printed
         */

        while(startRow <= endRow && startCol <= endCol) {

            for (i = startCol; i <= endCol; i++) {
                System.out.print(arr[startRow][i] + " ");
            }
            startRow++;

            for (i = startRow; i <= endRow; i++) {
                System.out.print(arr[i][endCol] + " ");
            }
            endCol--;

            if (startRow <= endRow) {
                for (i = endCol; i >= startCol; i--) {
                    System.out.print(arr[endRow][i] + " ");
                }
                endRow--;
            }

            if (startCol <= endCol) {
                for (i = endRow; i >= startRow; i--) {
                    System.out.print(arr[i][startCol] + " ");
                }
                startCol++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4},
                       {5, 6, 7, 8},
                       {9, 10, 11, 12},
                       {13, 14, 15, 16},
                       {17, 18, 19, 20},
                       {21, 22, 23, 24},
                       {25, 26, 27, 28}};
        printSpiral(arr, 3, 4);
    }
}
