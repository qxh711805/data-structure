package com.qxh.stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack=new ArrayStack(4);
        String key="";
        boolean loop=true;
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("show:展示");
            System.out.println("exit:退出");
            System.out.println("push:添加");
            System.out.println("pop:弹出");
            key=scanner.next();
            switch (key) {
                case "show":
                    arrayStack.list();
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                case "push":
                    System.out.println("请输入值");
                    int value = scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case "pop":
                    int pop = arrayStack.pop();
                    System.out.println("出栈的数据"+pop);
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

class ArrayStack{
    private int maxSize;
    private int[] stack;
    private int top=-1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack=new int[this.maxSize];
    }


    public void list(){
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        //遍历时从栈顶出数据
        for (int i = top; i >=0 ; i--) {
            System.out.println(stack[i]);
        }
    }

    public int pop(){
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        return stack[top--];

    }

    public void  push(int value){
        if (isFull()) {
            System.out.println("栈满，添加数据失败");
            return;
        }
        top++;
        stack[top]=value;
    }



    public boolean isFull(){
        return top==maxSize-1;
    }
    public boolean isEmpty(){
        return top==-1;
    }
}
