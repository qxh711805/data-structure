package com.test.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int sixe = 80000;
        int arr[] = new int[sixe];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(date);
        System.out.println("排序前时间" + format);
        selectSort(arr);
        Date date2 = new Date();
        String format2 = dateFormat.format(date2);
        System.out.println("排序后时间" + format2);

//        System.out.println(Arrays.toString(arr));
    }

    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex!=0){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }


        /*
        思路
        第一轮排序
        int minIndex = 0;
        int min = arr[0];
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < min) {
                min = arr[j];
                minIndex = j;
            }
        }
        if (minIndex!=0){
            arr[minIndex] = arr[0];
            arr[0] = min;

         第二轮排序
        int minIndex = 1;
        int min = arr[1];
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < min) {
                min = arr[j];
                minIndex = j;
            }
        }
        if (minIndex!=0){
            arr[minIndex] = arr[1];
            arr[1] = min;
        }*/
    }
}
