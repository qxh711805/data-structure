package com.test.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 插入排序
 */
public class InsertSort {
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
        insertSort(arr);
        Date date2 = new Date();
        String format2 = dateFormat.format(date2);
        System.out.println("排序后时间" + format2);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //定义要插入的数
            int insertValue = arr[i];
            int insertIndex = i - 1;

            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {

                //将后面的一个值移位到前一个，逐步寻找
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

//        当退出while 循环后， 找到要插入的位置
            arr[insertIndex + 1] = insertValue;
        }

        /*
        //定义要插入的数
        int insertValue=arr[1];
        int insertIndex=1-1;

        while (insertIndex>=0&& insertValue<arr[insertIndex]){
            arr[insertIndex+1] =insertValue;
            insertIndex--;
        }

//        当退出while 循环后， 找到要插入的位置
        arr[insertIndex+1]=insertValue;

         */
    }
}
