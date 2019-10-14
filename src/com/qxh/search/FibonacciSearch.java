package com.qxh.search;

/**
 * 斐波拉契数列查找，黄金分割
 */
public class FibonacciSearch {
    public static final int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 8, 100, 898};

        int[] fib = fib();
    }

    //生成斐波拉契数列
    private static int[] fib() {
        int[] fib = new int[maxSize];
        fib[0] = 1;
        fib[1] = 2;
        for (int i = 0; i < fib.length; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }
}
