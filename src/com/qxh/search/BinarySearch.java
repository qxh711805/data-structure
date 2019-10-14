package com.qxh.search;

/**
 * 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 8, 4};
        int searchValue = 5;
        int index=binarySearch(arr, 0,arr.length,searchValue);
        System.out.println(index);
    }

    private static int binarySearch(int[] arr, int left, int right, int searchValue) {
        if (left>right){
            return -1;
        }
        int mid =(left+right)/2;
        int midValue=arr[mid];
        //查询值大于中间值， 递归找右边
        if (searchValue>midValue){
            return binarySearch(arr,mid+1,right,searchValue);
        }
        // 小于 递归找左边
        if (searchValue<midValue){
            return binarySearch(arr,left,mid-1,searchValue);
        }
        else {
            return mid;
        }
    }


}
