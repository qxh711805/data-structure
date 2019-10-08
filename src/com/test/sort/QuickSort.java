package com.test.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {
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
        quickSort(arr, 0, arr.length - 1);
        Date date2 = new Date();
        String format2 = dateFormat.format(date2);
        System.out.println("排序后时间" + format2);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        //左下标
        int l = left;
        //右下标
        int r = right;
        //中轴
        int pivot = arr[(left + right) / 2];

        while (l < r) {
            //在 privot 左边一直找
            while (arr[l] < pivot) {
                l += 1;
            }
            //在 privot 左边一直找
            while (arr[r] > pivot) {
                r -= 1;
            }
            // l>=r  说明左边全部是小于等于 pivot
            if (l >= r) {
                break;
            }
            // 交换数据
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //交换完后，发现arr[l]==pivot,
            if (arr[l] == pivot) {
                l++;
                r--;
            }
            if (left < r) {
                quickSort(arr, left, r);
            }
            if (right > l) {
                quickSort(arr, l, right);
            }
        }
    }
}
