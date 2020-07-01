package com.youngtr.algorithminjava.sorting.basic;


import static com.youngtr.algorithminjava.utils.Swaper.swap;

/**
 * 冒泡排序
 * 从无序序列头部开始，进行两两比较，
 * 根据大小交换位置，直到最后将最大（小）的数据元素交换到了无序队列的队尾，
 * 从而成为有序序列的一部分；
 * 下一次继续这个过程，直到所有数据元素都排好序。
 */
public class BubbleSort {

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        int change = 1;
        for (int i = 0; i < n - 1 && change != 0; i++) {
            change = 0;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                    change = 1;
                }
            }

        }

    }


}
