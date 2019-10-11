package com.test.bianrysorttree;

/**
 * 二叉排序树
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr={ 10 , 60  ,9 ,15 ,8 ,7};
        BinarySortTree binarySortTree=new BinarySortTree();

        //循环添加二叉树
        for (int i = 0; i <arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
        binarySortTree.infixOrder();
    }
}

class BinarySortTree{
    private Node root;

    public void add(Node node){
        if (root==null){
            root=node;
        }
        else {
            root.add(node);
        }
    }
    //中序遍历
    public void infixOrder(){
        if (root!=null)
            root.infixOrder();
        else
            System.out.println("当前树为空");
    }
}

class Node{
    int value;
    Node left;
    Node right;

    //添加节点
    //递归方式添加节点，需要满足二叉排序树的需求
    public void add(Node node){
        if (node == null) {
            return;
        }
        //判断要添加的节点，是否比当前的节点的值小
        if (node.value <this.value) {
            //如果当前节点的左指节点为空
            if (this.left==null){
                this.left=node;
            }
            //则递归向左节点添加
            else {
                this.left.add(node);
            }
        }
        //大
        else {
            if (this.right==null){
                this.right=node;
            }
            else {
                this.right.add(node);
            }
        }
    }
    //中序遍历
    public void  infixOrder(){
        if (this.left!=null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right!=null){
            this.right.infixOrder();
        }
    }

    //构造参数
    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}