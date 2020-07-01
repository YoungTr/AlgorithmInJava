package com.youngtr.algorithminjava.utils;

public class Swaper {

    private Swaper() {
    }

    public static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
