package com.test.hashtable;

public class HashTableDemo {
    public static void main(String[] args) {

    }
}

//部门实体类
class Emp{
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

//部门链表
class EmpLinkedList{
    private Emp head;

    /**
     * 默认添加部门时，id 自增 ，加入数据时，默认添加到链表的最后
     * @param emp
     */
    public void add(Emp emp){
        if (head==null){
            head=emp;
            return;
        }
        //如果不是第一个，则需要一个辅助指针
        Emp curEmp=head;
        while (true){
            if (curEmp.next==null) {
                break;
            }
            curEmp=curEmp.next;
        }
        // 遍历获取到链表最后的数据， 。。 这样就加入到最后了
        curEmp.next=emp;
    }
    public void list(){

    }

}
