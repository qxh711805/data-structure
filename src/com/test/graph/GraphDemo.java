package com.test.graph;

import java.util.ArrayList;

/**
 *  图 147-
 */
public class GraphDemo {
    public static void main(String[] args) {
    }
}

class Graph{
    //存储顶点的集合
    private ArrayList<String> vertexList;
    //存储图对应的矩阵
    private int[][] edges;
    //表示边的数目
    private int numOfEdges;

    //构造器
    public Graph(int n) {
        edges=new int[n][n];
        vertexList=new ArrayList<String>(n);
        numOfEdges=0;
    }
    //插入节点
    public void insertVertx(String vertx){
        vertexList.add(vertx);
    }

    /**
     *  添加边
     * @param v1  表示点的下标 ，即第几个顶点
     * @param v2  第2个顶点对应的下标
     * @param weight 权重
     */
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
        numOfEdges++;
    }

    // 获取边的数目
    public int  getNumOfEdges(){
        return numOfEdges;
    }
    //获取顶点的个数
    public int getNumOfVertex(){
        return vertexList.size();
    }
}
