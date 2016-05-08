package com.akahuman.arrays;

/**
 * Created by akahuman on 1/5/16.
 * Given a sorted array, rearrange the elements alternatively in max, min order
 *
 * Input: {1, 2, 3, 4, 5, 6}
 * Output: {6, 1, 5, 2, 4, 3}
 */
public class MaxMinOrder {

    public static void swap(int[] arr, int src, int target) {
        int temp = arr[src];
        arr[src] = arr[target];
        arr[target] = temp;
    }

    public static void rearrange(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                continue;
            }

            int target = i < (arr.length / 2) ? (2 * i + 1) : (2 * (arr.length - i - 1));

            while (i != target) {
                swap(arr, i, target);
                // Marking as negative to know that this entry has been processed
                arr[target] = -arr[target];
                target = target < (arr.length / 2) ? (2*target+1) : 2*(arr.length-target-1);
            }

            // This means that src and target are same, which means no swapping needed.
            // Just mark the entry as processed and proceed with the next iteration.
            arr[i] = -arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = -arr[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        rearrange(arr);
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
