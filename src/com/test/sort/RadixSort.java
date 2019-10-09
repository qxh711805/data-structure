package com.test.sort;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 基数排序
 */
public class RadixSort {
    public static void main(String[] args) {
        int sixe = 8;
        int arr[] = new int[sixe];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(date);
        System.out.println("排序前时间" + format);
        radixSort(arr);
        Date date2 = new Date();
        String format2 = dateFormat.format(date2);
        System.out.println("排序后时间" + format2);
        System.out.println(Arrays.toString(arr));

    }

    private static void radixSort(int[] arr) {



    }
}
