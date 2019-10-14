package com.test.linkedlist;


/**
 *  经典约瑟夫问题
 *    环形链表
 *    问题：设编号有1 .2 ... n 个人坐一圈，约定从编号 k (1<=k<=n)开始数，数到第m个人出列， 直到所有的人出列，形成一个队列
 */
public class Jsosephu {
    public static void main(String[] args) {
        CircleSingleLinkedList circle=new CircleSingleLinkedList();
        circle.addBoy(5);
//        circle.showBoy();
        circle.countBoy(1,2,5);//24153
    }
}

class CircleSingleLinkedList{
    //创建一个first节点，给一个默认值，没有编号
    private Boy first=new Boy(-1);

    //创建小孩节点，构建成一个环形链表
    public void addBoy(int nums){
        // 对nums 做个数据校验
        if (nums<1){
            System.out.println("输入 的 num 不正确");
            return;
        }
        Boy curBoy=null;
        //使用for创建环形链表
        for (int i = 1; i <= nums; i++) {
            Boy boy=new Boy(i);
            if (i==1){
                first=boy;
                first.setNext(first);//构成环状
                curBoy=first;//让curBoy 指向第一个小孩
            }
            else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy=boy;
            }
        }
    }

    //遍历环形链表
    public void showBoy(){
        if (first==null){
            System.out.println("链表为空");
            return;
        }
        Boy curBoy=first;
        while (true){
            System.out.println("小孩的编号"+curBoy.getNo());
            if (curBoy.getNext()==first){
                break;
            }
            curBoy=curBoy.getNext();
        }
    }

    //根据用户的输入，计算小孩出圈的顺序
    public void countBoy(int startNo,int countNum,int nums){
        if (first==null|| startNo<1||startNo>nums){
            System.out.println("参数输入有误");
            return;
        }
        //创建一个辅助指针
        Boy helper=first;
        while (true){
            if (helper.getNext()==first) {
                break;
            }
            helper=helper.getNext();
        }
        //小孩报数前，先让first和helper移动k-1次
        for (int i = 0; i < startNo - 1; i++) {
            first=first.getNext();
            helper = helper.getNext();
        }


        while (true){
            //说明圈中只有一个节点
            if (first==helper){
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                first=first.getNext();
                helper=helper.getNext();
            }
            System.out.println("小孩出圈"+first.getNo());
            //出圈，先指向下一个节点， 然后再置空
            first=first.getNext();
            helper.setNext(first);
        }

        System.out.println("最后留在圈中的编号："+first.getNo());
    }
}

class Boy{
    private int no;

    private Boy next;

    public Boy getNext() {
        return next;
    }
    public void setNext(Boy next) {
        this.next = next;
    }

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}

