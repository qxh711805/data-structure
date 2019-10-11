package com.test.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 赫夫曼树 ， 也称最优二叉树 ，哈夫曼树
 *  wpl : 带权路径长度最小
 */
public class HuffmanTreeDemo {
    public static void main(String[] args) {
        int arr[] ={ 2 ,8 , 6 , 9 } ;
        Node root=createHuffmanTree(arr);
        preOrder(root);
    }

    private static void preOrder(Node root) {
        if (root!=null){
            root.perOrder();
        }
        else {
            System.out.println("赫夫曼树为空");
        }
    }

    /**
     *  创建赫夫曼树的方法
     * @param arr
     * @return
     */
    private static Node createHuffmanTree(int[] arr) {
        List<Node> nodes=new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }
        while (nodes.size()>1){
            Collections.sort(nodes);
            System.out.println(nodes);
            //1.取出节点最小的颗二叉树
            Node leftNode = nodes.get(0);
            //2.取出节点第二小的2颗二叉树
            Node rightNode = nodes.get(1);
            //3.构建一颗新的二叉树
            Node parent=new Node(leftNode.value+rightNode.value);
            parent.left=leftNode;
            parent.right=rightNode;
            //4.删除
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //5.将parent加入到原二叉树
            nodes.add(parent);
        }
        //删除
        return nodes.get(0);
    }

}

/**
 *  为了node 节点支持排序，Node 实现接口
 */
class Node implements Comparable<Node> {
    //节点权值
    int value;
    Node left;
    Node right;

    //前序遍历
    public void perOrder(){
        System.out.println(this);
        if (this.left!=null){
            this.left.perOrder();
        }
        if (this.right != null) {
            this.right.perOrder();
        }

    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //从小到大排序，如果想从大到小，在前面加个 负号
        return this.value-o.value;
    }
}
