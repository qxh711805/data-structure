package com.test.queue;

/**
 * 环形队列
 */
public class CircleQueueDemo {
    public static void main(String[] args) {
        //设置的4 ，其队列的最大有效队列为 3
        CircleQueue circleQueue=new CircleQueue(4);
        circleQueue.add(1);
        circleQueue.add(2);
        circleQueue.add(3);
        circleQueue.add(30);
        System.out.println("------------排序-----------");
        circleQueue.list();
        System.out.println("------------展示头-----------");
        System.out.println(circleQueue.headQuere());
        System.out.println("------------取值-----------");
        System.out.println(circleQueue.getQueue());
        System.out.println(circleQueue.getQueue());
        circleQueue.add(4);
        circleQueue.add(5);
        circleQueue.list();
    }
}
class CircleQueue{
    //最大容量
    private int maxSize;
    //队列头
    private int front;
    //队列尾
    private int rear;
    //该数组用于存放数据
    private int[] arr;

    public CircleQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        //队列头部
        front = 0;
        //队列尾
        rear = 0;
    }

    //获取头
    public int getQueue(){
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }
        //这里的front指向队列的第一个元素
        //1. 先将front 对应的值保留到临时变量
        //2. 将front 后移
        //3.
        int value=arr[front];
        front=(front+1)%maxSize;
        return value;
    }

    public void list(){
        System.out.println("------------排序-----------");
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.println(arr[i % maxSize]);
        }
    }

    public int headQuere(){
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }

    public int size(){
        return (rear + maxSize - front) % maxSize;
    }

    public void add(int value){
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        //直接将数据添加
        arr[rear] =value;
        //将 rear 后移
        rear = (rear+1)%maxSize;
    }

    //判断是否空
    public boolean isEmpty(){
        return rear==front;
    }
    //判断是否满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }
}