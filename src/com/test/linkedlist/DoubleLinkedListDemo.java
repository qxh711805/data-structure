package com.test.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("---------------双向链表测试--------------------");

        HeroNode2 heroNode1 = new HeroNode2(1, "1", "1");
        HeroNode2 heroNode2 = new HeroNode2(2, "2", "2");
        HeroNode2 heroNode3 = new HeroNode2(3, "3", "3");
        HeroNode2 heroNode4 = new HeroNode2(4, "4", "4");

        DoubleLinkedList doubleLinkedList=new DoubleLinkedList();
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode4);
        doubleLinkedList.list();
        System.out.println("-------------------------------------------");

        HeroNode2 updateHeroNode = new HeroNode2(4, "4444", "4444");
        doubleLinkedList.update(updateHeroNode);
        doubleLinkedList.list();
        System.out.println("-------------------------------------------");

        doubleLinkedList.delete(3);
        doubleLinkedList.list();
        System.out.println("-------------------------------------------");
    }
}

class DoubleLinkedList{
    //先初始化一个头节点，不存放任何数据
    private HeroNode2 head = new HeroNode2(0, "", "");

    //作业:按照编号顺序添加
    //  未完成

    /**
     *
     * @param heroNode
     */
    public void add(HeroNode2 heroNode) {
        //头节点不能动，我们需要一个临时节点来寻找
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            //如果没找到就将temp后移
            temp = temp.next;
        }
        //退出这个循环时，temp就指向链表的最后
        temp.next = heroNode;
        //形成双向链表
        heroNode.pre=temp;
    }

    //双向链表的修改和单项链表的修改 一样，
    public void update(HeroNode2 newHeroNode) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
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


    //双向链表的删除，找到节点之后，直接自我删除
    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            //遍历到最后
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            //方式
          temp.pre.next=temp.next;
            //添加判断，防止空指针异常
            if (temp.next != null) {
                temp.next.pre=temp.pre;
            }
        } else {
            System.out.println("没有找到要删除的节点" + no);
        }
    }

    //遍历
    public void list() {
        if (head.next == null) {
            return;
        }
        //因为头节点不能动，因此我们需要一个辅助变量
        HeroNode2 temp = head.next;
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

class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    //指向下一个节点
    public HeroNode2 next;
    //指向前一个节点
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickName) {
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