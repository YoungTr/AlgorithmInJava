package com.youngtr.algorithminjava.sorting.advance.heap.shiftup;


public class MaxHeap<Item> {
    private Item[] data;
    private int count;

    public MaxHeap(int capacity) {
        data = (Item[]) new Object[capacity + 1];
        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }
}
