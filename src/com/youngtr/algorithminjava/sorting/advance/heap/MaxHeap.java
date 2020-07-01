package com.youngtr.algorithminjava.sorting.advance.heap;


import com.youngtr.algorithminjava.utils.SortTestHelper;
import com.youngtr.algorithminjava.utils.Swaper;

/**
 * 堆树的定义：
 * 1. 堆树是一颗完全二叉树
 * 2. 堆树中某个节点的值总是不大于或者不小于其孩子节点的值
 * 3. 堆树中每个节点的子树都是堆树
 * 当父节点的键值总是大于或等于任何一个子节点的键值时为最大堆，
 * 当父节点的键值总是小于或等于任何一个子节点的键值时为最小堆；
 * <p>
 * 最大堆
 *
 * @param <Item> 元素
 */
public class MaxHeap<Item extends Comparable> {
    private Item[] data;
    private int count;
    private int capacity;

    public MaxHeap(int capacity) {
        data = (Item[]) new Integer[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    public MaxHeap(Comparable[] arr) {
        int n = arr.length;
        data = (Item[]) new Integer[n + 1];
        capacity = n;
        for (int i = 0; i < n; i++) {
            data[i + 1] = (Item) arr[i];
        }
        count = n;
        for (int i = count / 2; i > 0; i--) {
            shiftDown(i);
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(Item item) {
        assert count + 1 < capacity;
        data[count + 1] = item;
        count++;
        shiftUp(count);
    }

    private void shiftUp(int k) {
        // k/2 是 k 的父节点
        while (k > 1 && data[k].compareTo(data[k / 2]) > 0) {
            Swaper.swap(data, k, k / 2);
            k /= 2;
        }
    }

    public Item extractMax() {
        assert count >= 1;
        // 取出1位置的元素
        Item item = data[1];
        // 将 1 和 count 位置的元素交换位置
        Swaper.swap(data, 1, count);
        count--;
        shiftDown(1);
        return item;
    }

    private void shiftDown(int k) {
        // 有子节点才交换
        while (2 * k <= count) {
            // 左子节点
            int j = 2 * k;
            // 存在右子节点 && 右子节点>左子节点
            if (j + 1 <= count && data[j + 1].compareTo(data[j]) > 0) {
                j += 1;
            }
            // 如果父节点大于子节点，跳出循环
            if (data[k].compareTo(data[j]) > 0) {
                break;
            }
            // 交换位置
            Swaper.swap(data, k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(100);
        int N = 50;
        Integer[] values = SortTestHelper.generateRandomArray(N, 0, 100);
        for (int i = 0; i < N; i++) {
            maxHeap.insert(values[i]);
        }
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.extractMax() + " ");
        }
    }
}
