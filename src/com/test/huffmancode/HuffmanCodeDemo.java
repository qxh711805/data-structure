package com.test.huffmancode;


import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * 赫夫曼编码
 */
public class HuffmanCodeDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String content = "i like java very much";
        byte[] bytes = content.getBytes();
        List<Node> nodes = getNodes(bytes);
        System.out.println(nodes);
        Node huffmanTree = createHuffmanTree(nodes);
        preOrder(huffmanTree);
    }

    //获取这行数据中，字符出现的次数
    private static List<Node> getNodes(byte[] bytes) {
        //1.创建list集合，接收数据
        List<Node> nodes = new ArrayList<>();

        //用map 统计字符出现的次数
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            //判断count 是否是第一次出现，如果为空，则字符第一次出现
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }

        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }

        return nodes;
    }
    //前序遍历的方法
    public static void  preOrder(Node root){
        if (root!=null){
            root.preOrder();
        }
        else {
            System.out.println("树为空");
        }
    }

    //通过list 创建 一颗 赫夫曼树
    private static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size()>1){
            Collections.sort(nodes);
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parentNode = new Node(null, leftNode.weight + rightNode.weight);
            parentNode.left=leftNode;
            parentNode.right=rightNode;
            nodes.add(parentNode);
            nodes.remove(leftNode);
            nodes.remove(rightNode);
        }
        return nodes.get(0);
    }

}

class Node implements Comparable<Node> {
    //存放数据（字符）本身 ，比如 a=>'97' =>32
    Byte data;
    // 权重， 表示这个字符出现的次数
    int weight;
    Node left;
    Node right;

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }


    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}
