package com.akahuman.heap.minheap;

import com.google.common.collect.Maps;

/**
 * Created by akahuman on 1/5/16.
 */
public class MinHeapDriver {

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        minHeap.insert(10);
        minHeap.insert(7);
        System.out.println(minHeap);
        System.out.println(minHeap.getMin());

        minHeap.insert(2);
        minHeap.insert(24);
        minHeap.insert(1);
        System.out.println(minHeap);
        System.out.println(minHeap.getMin());

        int val = minHeap.deleteMin();
        System.out.println(minHeap);
        System.out.println("Deleted element: " + val);

        val = minHeap.deleteMin();
        System.out.println(minHeap);
        System.out.println("Deleted element: " + val);

        minHeap.insert(-3);
        minHeap.insert(23);
        minHeap.insert(-100);
        System.out.println(minHeap);
    }
}
