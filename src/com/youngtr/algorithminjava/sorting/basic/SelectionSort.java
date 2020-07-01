package com.youngtr.algorithminjava.sorting.basic;


import static com.youngtr.algorithminjava.utils.Swaper.swap;

/**
 * 第一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，
 * 然后再从剩余的未排序元素中寻找到最小（大）元素，然后放到已排序的序列的末尾。
 * 以此类推，直到全部待排序的数据元素的个数为零。
 * 选择排序是不稳定的排序方法。
 */
public class SelectionSort {


    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // 寻找[i, n) 区间里的最小值的索引
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

}
