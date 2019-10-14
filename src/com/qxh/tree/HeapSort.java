package com.qxh.tree;

/**
 * 堆排序 111节
 */
public class HeapSort {
    public static void main(String[] args) {
        //升序排列，大顶堆
        int [] arr ={ 4,6 ,5 ,8,7};
        heapSort(arr);
        adjustHeap(arr,0,0);
    }
    private static void heapSort(int[] arr) {
        System.out.println("堆排序");
    }

    /**
     * 完成将以 i 对应的非叶子结点
     * @param arr 待调整的数组
     * @param i 表示非叶子节点在数组中的索引
     * @param length 表示对多少个元素继续调整，length 是在逐渐减少
     */
    private static void adjustHeap(int[] arr, int i, int length) {
    }



}
