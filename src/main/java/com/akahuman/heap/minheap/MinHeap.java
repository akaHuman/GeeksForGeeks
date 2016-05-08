package com.akahuman.heap.minheap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akahuman on 1/5/16.
 */
public class MinHeap {
    private List<Integer> elements;

    public MinHeap() {
        this(16);
    }

    public MinHeap(int capacity) {
        this.elements = new ArrayList<Integer>(capacity);
    }

    private void heapify(int index) {

    }

    private int getParentIndex(int cIndex) {
        return (cIndex - 1)/2;
    }

    private int getMinChildIndex(int pIndex) {
        int lChildIndex = 2 * pIndex + 1;
        int rChildIndex = 2 * pIndex + 2;

        int lChild;
        if (lChildIndex > elements.size()) {
            return -1;
        } else {
            lChild = elements.get(lChildIndex);
        }

        if (rChildIndex >= elements.size()) {
            return lChildIndex;
        } else {
            if (lChild > elements.get(rChildIndex)) {
                return rChildIndex;
            } else {
                return lChildIndex;
            }
        }
    }

    private void percolateUp(int index) {
        if (index != 0) {
            int pIndex = getParentIndex(index);
            int minCIndex = getMinChildIndex(pIndex);
            if (elements.get(pIndex) > elements.get(minCIndex)) {
                swap(pIndex, minCIndex);
                percolateUp(pIndex);
            }
        }
    }

    private void percolateDown(int index) {
        int minChildIndex = getMinChildIndex(index);

        if (minChildIndex == -1) {
            return;
        }

        if (elements.get(index) > elements.get(minChildIndex)) {
            swap(index, minChildIndex);
            percolateDown(minChildIndex);
        }
    }

    private void swap(int src, int target) {
        int temp = elements.get(src);
        elements.set(src, elements.get(target));
        elements.set(target, temp);
    }

    public void insert(int val) {
        elements.add(val);
        percolateUp(elements.size() - 1);
    }

    public int getMin() {
        return elements.get(0);
    }

    public int deleteMin() {
        int val = getMin();
        elements.set(0, elements.get(elements.size() - 1));
        elements.remove(elements.size() - 1);
        percolateDown(0);
        return val;
    }

    public String toString() {
        StringBuffer strBuf = new StringBuffer();
        for (int n : elements) {
            strBuf.append(n + " ");
        }
        return strBuf.toString();
    }
}
