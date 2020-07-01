package com.youngtr.algorithminjava.sorting.advance.heap;

import com.youngtr.algorithminjava.utils.Printer;
import com.youngtr.algorithminjava.utils.SortTestHelper;

import java.util.Arrays;

public class HeapSort1 {


    public static void sort(Integer[] arr) {
        int n = arr.length;
        MaxHeap<Integer> maxHeap = new MaxHeap<>(n);
        // 插入数据
        for (Integer integer : arr) {
            maxHeap.insert(integer);
        }

        for (int i = n - 1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }

    public static void sort1(Integer[] arr) {
        int n = arr.length;
        MaxHeap<Integer> maxHeap = new MaxHeap<>(arr);
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }

    public static void main(String[] args) {
        int N = 50;
        Integer[] values = SortTestHelper.generateRandomArray(N, 0, 100);
        Integer[] values2 = Arrays.copyOf(values, N);
        HeapSort1.sort(values);
        HeapSort1.sort1(values2);
        Printer.printArr(values);
        Printer.printArr(values2);
    }

}
