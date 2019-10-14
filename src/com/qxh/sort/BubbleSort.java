package com.qxh.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
//        int arr[] = {2, 3, 4,  5, 6, 8};
        int sixe=8;

        int arr[]=new int[sixe];

        for (int i = 0; i < arr.length; i++) {
            arr[i]= (int) (Math.random()*80000);
        }
        Date date=new Date();
        System.out.println(date);
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(date);
        System.out.println("排序前时间"+format);

        bubbleSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        int temp = 0;

        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第" + (i+1) + "次交换");

            // 如果一次都没有发生交换 ，flag=false
            if (!flag) {
                break;
            } else {
                flag = true;
            }
        }
    }
}

