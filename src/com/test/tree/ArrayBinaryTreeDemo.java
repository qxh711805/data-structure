package com.test.tree;

/**
 * 顺序二叉树
 * 1.顺序二叉树只考虑完全二叉树
 * 2.第n 个元素的左子节点为 2*n+1
 * 3.第n 个元素的右子节点为 2*n+2
 * 4.第n 个元素的父节点为（n-1）/2
 * 5. n表示二叉树的第几个元素
 *
 * 本节展示顺序存储二叉树
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {

        int[] arr={1,2,3,4,5,6,7,};
        ArrayBinaryTree arrayBinaryTree=new ArrayBinaryTree(arr);
        arrayBinaryTree.proOrder();

    }
}
class ArrayBinaryTree{
    //存储数据节点的数组
    private int [] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void proOrder(){
        this.proOrder(0);
    }

    public void proOrder(int index){
        if (arr==null||arr.length==0){
            System.out.println("数组为空");
        }
        //输出这个元素
        System.out.println(arr[index]);

        //向左递归遍历
        if ((index*2+1)<arr.length) {
            proOrder(2*index+1);
        }
        //向右递归遍历
        if ((index*2+2)<arr.length){
            proOrder(index*2+2);
        }
    }

}