package com.test.queue;

/**
 * 数组模拟队列 , 单项队列
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue=new ArrayQueue(5);
        arrayQueue.add(1);
        arrayQueue.add(2);
        arrayQueue.add(3);
        arrayQueue.list();
        int peek = arrayQueue.peek();
        System.out.println(peek);
    }
}

class ArrayQueue {
    //最大容量
    private int maxSize;
    //队列头
    private int front;
    //队列尾
    private int rear;
    //该数组用于存放数据
    private int[] arr;

    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        //队列头部
        front = -1;
        //队列尾
        rear = -1;
    }
    //显示数据
    public void list(){
        if (isEmpty()) {
            System.out.println("队列数据为空");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    //显示队列的头数据
    public int peek(){
        if (isEmpty()) {
            throw new RuntimeException("没有数据");
        }
        return arr[front + 1];
    }

    //出队列
    public int getQueue(){
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }
        front++;
        return arr[front];
    }

    //添加数据
    public void add(int value){
        if (isFull()) {
            System.out.println("队列满，不能添加");
            return;
        }
        //后移
        rear++;
        arr[rear]=value;
    }

    //判断队列是否满
    public boolean isFull(){
        return rear==front-1;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return rear==front;
    }
}
