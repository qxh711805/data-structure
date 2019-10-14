package com.qxh.sparsearray;

/**
 * 稀疏数组
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组 11* 11
        //0  表示棋盘 1 表示黑子 2表示白
        int[][] chessArr1 =new int[11][11];
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;
        System.out.println("----------------原始二维数组-------------");
        for (int[] ints : chessArr1) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }
        // 将 二维数组转换 成稀疏数组思想
        //1.遍历
        int sum=0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j]!=0){
                    sum++;
                }
            }
        }
        int[][] sparseArray=new int[sum+1][3];
        //给稀疏数组赋值
        sparseArray[0][0]=11;
        sparseArray[0][1]=11;
        sparseArray[0][2]=sum;

        int count =0 ;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr1[i][j];
                }
            }
        }

        for (int i = 0; i < sparseArray.length; i++) {
            for (int j = 0; j < sparseArray.length; j++) {
                System.out.println(sparseArray[i][j]);
            }
        }
    }
}
