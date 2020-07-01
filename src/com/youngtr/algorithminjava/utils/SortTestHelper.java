package com.youngtr.algorithminjava.utils;

import java.lang.reflect.Method;
import java.util.Random;

public class SortTestHelper {

    /**
     * 生成 n 个元素的随机数组，每个元素的范围为[rangL, rangR]
     *
     * @param n     size
     * @param rangL L
     * @param rangR R
     * @return Integer[]
     */
    public static Integer[] generateRandomArray(int n, int rangL, int rangR) {
        assert rangL <= rangR;
        Integer[] arr = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(rangR - rangL + 1) + rangL;
        }
        return arr;
    }

    public static Integer[] generateNearlyOrderedArray(int n, int swapTime) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        Random random = new Random();

        for (int i = 0; i < swapTime; i++) {
            int a = random.nextInt(n);
            int b = random.nextInt(n);

            int t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }

        return arr;
    }


    /**
     * 数组是否有序
     *
     * @param arr 数组
     * @return true 有序
     */
    public static boolean isSorted(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i].compareTo(arr[i + 1]) > 0)
                return false;
        return true;
    }

    // 测试sortClassName所对应的排序算法排序arr数组所得到结果的正确性和算法运行时间
    public static void testSort(String sortClassName, Comparable[] arr) {

        // 通过Java的反射机制，通过排序的类名，运行排序函数
        // * 依然是，使用反射机制并不是这个课程的重点, 大家也完全可以使用自己的方式书写代码, 最终只要能够测试出自己书写的算法的效率即可
        // * 推荐大家阅读我在问答区向大家分享的一个学习心得: 【学习心得分享】请大家抓大放小，不要纠结于C++语言的语法细节
        // * 链接: http://coding.imooc.com/learn/questiondetail/4100.html
        try {
            // 通过sortClassName获得排序函数的Class对象
            Class sortClass = Class.forName(sortClassName);
            // 通过排序函数的Class对象获得排序方法
            Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable[].class});
            // 排序参数只有一个，是可比较数组arr
            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            // 调用排序函数
            sortMethod.invoke(null, params);
            long endTime = System.currentTimeMillis();

             if (!isSorted(arr)) {
                 throw new Exception("arr is not sorted");
             }

            System.out.println(sortClass.getSimpleName() + " : " + (endTime - startTime) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
