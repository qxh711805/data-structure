package com.qxh.linkedlist;

/**
 * 单项链表
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "1", "1");
        HeroNode heroNode2 = new HeroNode(2, "2", "2");
        HeroNode heroNode3 = new HeroNode(3, "3", "3");
        HeroNode heroNode4 = new HeroNode(4, "4", "4");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //添加到链表的末尾
        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.add(heroNode4);
        System.out.println("----------------------------------------");
        singleLinkedList.list();

        //按照顺序添加
//        singleLinkedList.addByOrder(heroNode1);
//        singleLinkedList.addByOrder(heroNode4);
//        singleLinkedList.addByOrder(heroNode2);
//        singleLinkedList.addByOrder(heroNode3);
//        singleLinkedList.list();

        //测试修改节点的代码
//        HeroNode updateHeroNode = new HeroNode(2, "222", "222");
//        singleLinkedList.update(updateHeroNode);
//        System.out.println("----------------------------------------");
//        singleLinkedList.list();

        //测试删除
//        singleLinkedList.delete(heroNode2);
//        singleLinkedList.delete(heroNode4);
//        System.out.println("----------------------------------------");
//        singleLinkedList.list();

        //测试链表的长度
        System.out.println(singleLinkedList.getLength());

    }
}


class SingleLinkedList {
    //先初始化一个头节点，不存放任何数据
    private HeroNode head = new HeroNode(0, "", "");


    //获取节点的有效个数
    public int getLength() {
        if (head.next == null) {
            System.out.println("链表为空");
            return 0;
        }
        int length = 0;
        HeroNode temp = head.next;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;

    }


    // 添加节点到链表中
    //思路：1.当前不考虑编号顺序。2.将最后一个节点指向下一个节点

    /**
     * 1.
     * 按照顺序添加的实现
     *
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        //头节点不能动，我们需要一个临时节点来寻找
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            //如果没找到就将temp后移
            temp = temp.next;
        }
        //退出这个循环时，temp就指向链表的最后
        temp.next = heroNode;
    }

    public void update(HeroNode newHeroNode) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                //已经遍历完成
                break;
            }
            if (temp.no == newHeroNode.no) {
                //找到要修改的节点
                flag = true;
                break;
            }
            //指向下一个节点
            temp = temp.next;
        }
        //根据flag判断是否找到修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {
            System.out.println("没找到编号为" + newHeroNode.no + "节点");
        }
    }

    public void delete(HeroNode deleteHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            //遍历到最后
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == deleteHeroNode.no) {
                flag = true;
                break;
            }

            temp = temp.next;
        }
        if (flag) {
            //方式1 ，老师说的方式
            temp.next = temp.next.next;
//            temp.next=deleteHeroNode.next;
        } else {
            System.out.println("没有找到要删除的节点" + deleteHeroNode.no);
        }

    }


    /**
     * 按照编号的顺序添加
     *
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode) {
        //头节点不能动，我们需要一个临时节点来寻找
        HeroNode temp = head;

        boolean flag = false;
        while (true) {
            //当temp的下一个节点为空，则在链表的最后位置
            if (temp.next == null) {
                break;
            }

            //找到位置，
            if (temp.next.no > heroNode.no) {
                break;
            }
            //说明编号存在，不能添加
            else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            //后移
            temp = temp.next;
        }
        //判断flag的值
        //如果为真，则不能添加
        if (flag) {
            System.out.println("插入的编号已经存在，不能添加" + heroNode.no);
        }
        //否则可以添加
        else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }


    }

    //遍历
    public void list() {
        if (head.next == null) {
            return;
        }
        //因为头节点不能动，因此我们需要一个辅助变量
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表的最后
            if (temp == null) {
                break;
            }
            //输出temp ，
            System.out.println(temp);
            // 将temp 后移
            temp = temp.next;
        }
    }

}

class HeroNode {
    public int no;
    public String name;
    public String nickName;
    //指向下一个节点
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}