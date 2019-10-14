package com.qxh.search;


/**
 * 插值查找法
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        int findValue = 30;
        int index = insertValueSearch(arr, 0, arr.length-1, findValue);
        System.out.println(index);
    }

    private static int insertValueSearch(int[] arr, int left, int right, int findValue) {
        if (left > right || findValue < arr[0] || findValue > arr[arr.length - 1]) {
            return -1;
        }
        int mid=left + (right+left) *(findValue-arr[left])/(arr[right]-arr[left]);
        int midValue=arr[mid];
        if (findValue>midValue){
            insertValueSearch(arr,mid+1,right,findValue);
        }
        if (findValue<midValue){
            insertValueSearch(arr,left,mid-1,findValue);
        }
        else {
            return mid;
        }
        return -1;
    }
}
