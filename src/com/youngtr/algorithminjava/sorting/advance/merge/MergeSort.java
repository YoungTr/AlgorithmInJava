package com.youngtr.algorithminjava.sorting.advance.merge;


import com.youngtr.algorithminjava.sorting.basic.InsertionSort;

public class MergeSort {

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        mergeSort(arr, 0, n - 1);
    }

    public static void sortBU(Comparable[] arr) {
        int n = arr.length;
        for (int sz = 1; sz <= n; sz += sz) {
            for (int i = 0; i + sz < n; i += sz + sz) {
                int l = i, mid = i + sz - 1, r = Math.min(i + sz + sz - 1, n - 1);
                System.out.println(String.format("%d %d %d\n", l, mid, r));
                merge(arr, l, mid, r);
            }
        }
    }

    /**
     * 递归使用并归
     *
     * @param arr
     * @param l
     * @param r
     */
    private static void mergeSort(Comparable[] arr, int l, int r) {
//        if (l >= r) {
//            return;
//        }
        // 优化二
        // 当数组较小时，认为此时数组近乎有序
        // 可以使用插入算法优化(O(n))
        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }

        int mid = l + ((r - l) >> 2);
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        // 优化一
        // 当 arr[mid] <= arr[mid + 1] 说明已经有序，不用归并
        // 当 arr[mid] > arr[mid + 1] 才进行归并
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
        }
    }

    private static void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux = new Comparable[r - l + 1];
        // 临时空间赋值操作
        for (int i = l; i <= r; i++) {
            aux[i - l] = arr[i];
        }

        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l].compareTo(aux[j - l]) < 0) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }

    }

}
