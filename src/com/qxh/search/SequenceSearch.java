package com.qxh.search;

/**
 * 线性查找
 */
public class SequenceSearch {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 8, 4};
        int searchValue = 0;
        int index = sequenceSearch(arr, searchValue);
        System.out.println(index);
    }

    private static int sequenceSearch(int[] arr, int searchValue) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == searchValue) {
                return i;
            }
        }
        return -1;
    }
}
