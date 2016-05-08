package com.akahuman.arrays;

import com.google.common.collect.Maps;

import java.util.HashMap;

/**
 * Created by akahuman on 1/5/16.
 *
 * Count the number of pairs in an array whose sum is equal to a given number.
 */
public class PairSum {

    public static int getNumPairs(int[] arr, int sum) {
        int numPairs = 0;

        HashMap<Integer, Integer> freqMap = Maps.newHashMap();
        for (int num : arr) {
            int oldVal = 0;
            if (freqMap.containsKey(num)) {
                oldVal = freqMap.get(num);
            }
            freqMap.put(num, ++oldVal);
        }

        for (int num : arr) {
            int reqNum = sum - num;
            if (freqMap.containsKey(reqNum)) {
                numPairs += freqMap.get(reqNum);
            }

            // If same then dec one as counted itself as well
            if (reqNum == num) {
                numPairs -= 1;
            }
        }

        // Divide by 2 as every pair is counted twice when we scan the array
        return numPairs / 2;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 1, 1, 1};
        System.out.println(getNumPairs(arr, 0));
    }
}
