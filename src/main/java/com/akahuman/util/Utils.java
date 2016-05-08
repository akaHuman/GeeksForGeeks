package com.akahuman.util;

/**
 * Created by akahuman on 7/5/16.
 */
public class Utils {

    public static void printArr(int[][] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
