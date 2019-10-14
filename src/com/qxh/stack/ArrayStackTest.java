//package com.qxh.stack;
//
//public class ArrayStackTest {
//    public static void main(String[] args) {
//        ArrayStack arrayStack = new ArrayStack(3);
//        arrayStack.push(1);
//        arrayStack.display();
//        System.out.println("栈顶的元素" + arrayStack.peek());
//        arrayStack.push(2);
//        System.out.println("弹出栈顶的元素" + arrayStack.pop());
//        arrayStack.display();
//    }
//}
//
//class ArrayStack {
//    private long[] a;
//    //栈数组的大小
//    private int size;
//    //栈顶
//    private int top;
//
//    public ArrayStack(int maxSize) {
//        this.size = maxSize;
//        this.a = new long[size];
//        //-1 表示空栈
//        this.top = -1;
//    }
//
//    /**
//     * 入栈
//     *
//     * @param value
//     */
//    public void push(long value) {
//        if (isFull()) {
//            System.out.println("栈元素已满，不能添加元素");
//        }
//        a[++top] = value;
//    }
//
//
//    //弹出栈中的元素， 要删除
//    public long pop() {
//        if (isEmpty()) {
//            throw new RuntimeException("没有元素");
//        }
//        return a[top--];
//    }
//
//    //展示栈顶的元素,不删除
//    public long peek() {
//        if (isEmpty()) {
//            throw new RuntimeException("没有元素");
//        }
//        return a[top];
//    }
//
//    //展示栈中的元素
//    public void display() {
//        if (isEmpty()) {
//            System.out.println("栈元素为空");
//            return;
//        }
//        for (int i = 0; i < a.length; i++) {
//            System.out.print(a[i] + "       ");
//        }
//    }
//
//    //判断是否已经满
//    public boolean isFull() {
//        return (top == size - 1);
//    }
//
//    //判断是否为空
//    public boolean isEmpty() {
//        return (top == -1);
//    }
//
//    //获取数组的数量
//    public int getSize() {
//        return top + 1;
//    }
//
//
//}
