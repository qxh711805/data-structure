package com.test.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int sixe = 10;
        int arr[] = new int[sixe];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(date);
        System.out.println("排序前时间" + format);
        //交换法
//        shellSort(arr);
        //移位法
        shellSort2(arr);

        Date date2 = new Date();
        String format2 = dateFormat.format(date2);
        System.out.println("排序后时间" + format2);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 移位法
     * @param arr
     */
    private static void shellSort2(int[] arr) {

        for (int grp = arr.length / 2; grp > 0; grp /= 2) {
            for (int i = grp; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - grp]) {
                    while (j - grp >= 0 && temp < arr[j - grp]) {
                        //移动
                        arr[j] = arr[j - grp];
                        j -= grp;
                    }
                    //当退出while 循环后，就给temp找到了插入的位置
                    arr[j]=temp;
                }
            }
        }

    }

    /**
     *  交换法
     *  希尔排序第一种方式，交换位置 。。效率比较低
     * @param arr
     */
    private static void shellSort(int[] arr) {
        int temp = 0;

        // 步长 grp
        for (int grp = arr.length / 2; grp > 0; grp /= 2) {
            for (int i = grp; i <arr.length; i++) {
                for (int j = i - grp; j >= 0; j -= grp) {
                    //当前的数大于 步长5的那个元素就交换
                    if (arr[j] > arr[j + grp]) {
                        temp = arr[j];
                        arr[j] = arr[j + grp];
                        arr[j + grp] = temp;
                    }
                }
            }
        }
        /*
        int temp=0;
        //一共10个 元素  10/2=5
        for (int i = 5; i >0; i++) {
            // 步长减 5
            for (int j = i-5; j >=0; j-=5) {
                //当前的数大于 步长5的那个元素就交换
                if (arr[j]>arr[j+5]) {
                    temp=arr[j+5];
                    arr[j+5]=arr[j];
                    arr[j]=temp;
                }
            }
        }

        //个 元素  5/2=2
        for (int i = 2; i >0; i++) {
            // 步长减 5
            for (int j = i-2; j >=0; j-=2) {
                //当前的数大于 步长5的那个元素就交换
                if (arr[j]>arr[j+2]) {
                    temp=arr[j+2];
                    arr[j+2]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        
         */
    }
}
