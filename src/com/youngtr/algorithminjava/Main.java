package com.youngtr.algorithminjava;

import com.youngtr.algorithminjava.sorting.advance.merge.MergeSort;
import com.youngtr.algorithminjava.utils.SortTestHelper;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int n = 100;
        int rangL = 0;
        int rangR = 10000;
        int swapTime = 10;
//        Integer[] a = SortTestHelper.generateNearlyOrderedArray(n, 0);
        Integer[] a = SortTestHelper.generateRandomArray(n, rangL, rangR);

        Integer[] b = Arrays.copyOf(a, n);

        MergeSort.sortBU(a);

        boolean sorted = SortTestHelper.isSorted(a);
        System.out.println(sorted);

//        SortTestHelper.testSort("com.young.algorithminjava.sorting.basic.InsertionSort", a);
//        SortTestHelper.testSort("com.young.algorithminjava.sorting.basic.BubbleSort", a);
//        SortTestHelper.testSort("com.youngtr.algorithminjava.sorting.advance.merge.MergeSort", b);
//        SortTestHelper.testSort("com.young.algorithminjava.sorting.basic.SelectionSort", b);
//        printArr(a);
    }


}
