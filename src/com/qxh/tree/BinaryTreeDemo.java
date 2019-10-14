package com.qxh.tree;

/**
 * 二叉树
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        //创建二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的节点
        HeroNode root = new HeroNode(1, "1");
        HeroNode heroNode2 = new HeroNode(2, "2");
        HeroNode heroNode3 = new HeroNode(3, "3");
        HeroNode heroNode4 = new HeroNode(4, "4");
        HeroNode heroNode5 = new HeroNode(5, "5");

        root.setLeft(heroNode2);
        root.setRight(heroNode3);
        heroNode3.setRight(heroNode4);
        heroNode3.setLeft(heroNode5);
        //加入到二叉树
        binaryTree.setRoot(root);

//        System.out.println("-----------前序遍历-------------");
//        binaryTree.proOrder();
//        System.out.println("-----------中序遍历-------------");
//        binaryTree.infixOrder();
//        System.out.println("-----------后序遍历-------------");
//        binaryTree.postOrder();

//        System.out.println("-----------前序查找-------------");
//        HeroNode proOrderSearch = binaryTree.proOrderSearch(3);
//        System.out.println(proOrderSearch);
//
//        System.out.println("-----------中序查找-------------");
//        HeroNode infixOrderSearch = binaryTree.infixOrderSearch(30);
//        System.out.println(infixOrderSearch);
//
//        System.out.println("-----------后序查找-------------");
//        HeroNode postOrderSearch = binaryTree.postOrderSearch(3);
//        System.out.println(postOrderSearch);

        System.out.println("----------------删除前------------------");
        binaryTree.proOrder();
        binaryTree.deleteNode(3);
        System.out.println("----------------删除后------------------");
        binaryTree.proOrder();
    }
}

class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }
    //删除节点
    public void deleteNode(int no){
        if (root != null) {
            if (root.getNo()==no){
                root=null;
            }
            else {
                root.deleteNode(no);
            }
        }
        else {
            System.out.println("树为空");
        }
    }



    //前序遍历
    public void proOrder() {
        if (this.root != null)
            this.root.proOrder();
        else
            System.out.println("二叉树为空");
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null)
            this.root.infixOrder();
        else
            System.out.println("二叉树为空");
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null)
            this.root.postOrder();
        else
            System.out.println("二叉树为空");
    }

    //前序查找
    public HeroNode proOrderSearch(int no){
        return this.root.proOrderSearch(no);
    }

    //中序查找
    public HeroNode infixOrderSearch(int no){
        return this.root.infixOrderSearch(no);
    }

    //后序查找
    public HeroNode postOrderSearch(int no){
        return this.root.postOrderSearch(no);
    }
}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public HeroNode() {
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }


    //节点的前序，中序，后序

    public void proOrder() {
        System.out.println(this);
        //递归向左子树遍历
        if (this.left != null) {
            this.left.proOrder();
        }
        //递归向右子树遍历
        if (this.right != null) {
            this.right.proOrder();
        }
    }

    public void infixOrder() {

        //递归向左子树遍历
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        //递归向右子树遍历
        if (this.right != null) {
            this.right.infixOrder();
        }
    }


    public void postOrder() {
        //递归向左子树遍历
        if (this.left != null) {
            this.left.infixOrder();
        }
        //递归向右子树遍历
        if (this.right != null) {
            this.right.infixOrder();
        }
        System.out.println(this);
    }

    //前序查找
    public HeroNode proOrderSearch(int no) {
        //根
        if (this.no == no) {
            return this;
        }
        HeroNode resoultNode = null;
        //左
        if (this.left != null) {
            resoultNode = this.left.proOrderSearch(no);
        }
        if (resoultNode != null) {
            return resoultNode;
        }
        //右
        if (this.right != null) {
            resoultNode = this.right.proOrderSearch(no);
        }
        return resoultNode;
    }

    //中序查找
    public HeroNode infixOrderSearch(int no) {
        HeroNode resoultNode = null;
        //左
        if (this.left != null) {
            resoultNode = this.left.infixOrderSearch(no);
        }
        if (resoultNode != null) {
            return resoultNode;
        }
        //根
        if (this.no == no) {
            return this;
        }
        //右
        if (this.right != null) {
            resoultNode = this.right.infixOrderSearch(no);
        }
        return resoultNode;
    }

    //后序查找
    public HeroNode postOrderSearch(int no) {
        HeroNode resoultNode = null;
        //左
        if (this.left != null) {
            resoultNode = this.left.postOrderSearch(no);
        }
        if (resoultNode != null) {
            return resoultNode;
        }
        //右
        if (this.right != null) {
            resoultNode = this.right.postOrderSearch(no);
        }
        //根
        if (this.no == no) {
            return this;
        }
        return resoultNode;
    }

    //递归删除节点：1.叶子节点就删除该节点 2.如果不是叶子节点，就删除该子树
    public void deleteNode(int no) {
        if (this.left!=null&&this.left.no==no) {
            this.left=null;
            return;
        }
        if (this.right != null && this.right.no==no) {
            this.right=null;
            return;
        }
        //  需要向左子树递归删除
        if (this.left!=null){
            this.left.deleteNode(no);
        }
        //  需要向右子树递归删除
        if (this.right != null) {
            this.right.deleteNode(no);
        }
    }
}
