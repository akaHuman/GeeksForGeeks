package com.akahuman.arrays;

/**
 * Created by akahuman on 1/5/16.
 *
 *  Count minimum number of operations needed to convert an all-zero array to
 *  a given target array. Only two operations possible:
 *  1. Double all array elements
 *  2. Increment an array element
 *
 *  Input: {2, 1}
 *  Output: 3
 *
 *  Input: {2, 3}
 *  Output: 4
 *
 *  Input: {16, 16, 16}
 *  Output: 7
 */
public class MinSteps {

    private static void decOne(int[] arr, int index) {
        arr[index]--;
    }

    private static int halveAll(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] /= 2;
        }
        return 1;
    }

    private static int scanAndDecOneIfOdd(int[] arr) {
        int steps = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                decOne(arr, i);
                steps++;
            }
        }
        return steps;
    }

    private static boolean areAllZero(int[] arr) {
        for (int x : arr) {
            if (x != 0) {
                return false;
            }
        }
        return true;
    }

    public static int minStepsToTargetArray(int[] targetArr) {
        int totalSteps = 0;

        while(true) {
            if (areAllZero(targetArr)) {
                break;
            }
            totalSteps += scanAndDecOneIfOdd(targetArr);

            if (areAllZero(targetArr)) {
                break;
            }
            totalSteps += halveAll(targetArr);
        }

        return totalSteps;
    }

    public static void main(String[] args) {
        int[] targetArr = {0, 0};
        System.out.println(minStepsToTargetArray(targetArr));
    }
}
