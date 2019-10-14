package com.qxh.ten_algorithms;

/**
 * 汉罗塔，分治算法解决
 */
public class HanrotaDemo {
    public static void main(String[] args) {

        hanrota(5,'A','B','C');
    }

    private static void hanrota(int num,char a,char b,char c) {
        //如果只有一个塔
        if (num==1){
            System.out.println("第"+num+" 个盘"+a +"->"+c);
        }
        else {
            //1.先将最上面的盘A->B,移动过程会使用到C
            hanrota(num-1,a,c,b);
            //2.
            System.out.println("第"+num+" 个盘"+a+"->"+c);
            //3.将上面的盘B->C,移动过程会使用到A
            hanrota(num-1,b,a,c);
        }
    }
}
