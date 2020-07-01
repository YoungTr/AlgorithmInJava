package com.youngtr.algorithminjava.sorting.basic;

public class InsertionSort {


    /**
     * 它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
     * 插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），
     * 因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
     *
     * @param arr
     */
    public static void sort(Comparable[] arr) {
        int n = arr.length;

        // 写法一
//        for (int i = 1; i < n; i++) {
//            for (int j = i; j > 0; j--) {
//                // 如果 arr[j] < arr[j - 1], arr[j] 与 arr[j - 1] 交换位置
//                if (arr[j].compareTo(arr[j - 1]) < 0) {
//                    swap(arr, j, j - 1);
//                } else {
//                    break;
//                }
//            }
//        }

        // 写法二
//        for (int i = 1; i < n; i++) {
//            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
//                swap(arr, j, j - 1);
//            }
//        }

        // 写法三
        for (int i = 1; i < n; i++) {
            Comparable e = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1].compareTo(e) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }

    public static void sort(Comparable[] arr, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            Comparable e = arr[i];
            int j;
            for (j = i; j > l && arr[j - 1].compareTo(e) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;

        }
    }
}
