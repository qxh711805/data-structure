package com.qxh.ten_algorithms;

import java.util.Arrays;

/**
 * 二分查找，非递归算法
 */
public class BinarySearchNoRecur {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 6, 2, 4};
        Arrays.sort(arr);
        int index = binarySearchNoRecur(arr, 1);
        System.out.println(index);
    }

    /**
     * @param arr    默认arr 是升序的
     * @param target
     * @return
     */
    private static int binarySearchNoRecur(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        //说明继续查找
        while (left <= right) {
            int mid = (left + right) / 2;
            int midValue = arr[mid];
            if (midValue == target) {
                return mid;
            } else if (midValue > target) {
                right = mid - 1;//需要向左边查找
            } else {
                left = mid + 1;//需要向右边查找
            }
        }
        return -1;
    }
}
