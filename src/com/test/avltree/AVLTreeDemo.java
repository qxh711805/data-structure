package com.test.avltree;

/**
 * 平衡二叉树 又名avl树
 *  左旋转
 */
public class AVLTreeDemo {
    public static void main(String[] args) {
        //int[] arr = {4, 3, 6, 5, 7, 8};
        int[] arr = {10, 12, 8, 9, 7, 6};
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }
        //中序遍历avl树
        avlTree.infixOrder();
        System.out.println("------------在做旋转（平衡处理）之前------------");
        System.out.println("树的高度 = " + avlTree.getRoot().height());
        System.out.println("树的左子树高度 = " + avlTree.getRoot().left.height());
        System.out.println("树的右子树高度 = " + avlTree.getRoot().right.height());

        System.out.println("----------------------------------------------");
        System.out.println(avlTree.getRoot());
        System.out.println(avlTree.getRoot().left);
        System.out.println(avlTree.getRoot().right);

    }
}

class AVLTree {


    private Node root;

    public Node getRoot() {
        return root;
    }

    //删除节点
    public void deleteNode(int value) {
        if (root == null) {
            return;
        } else {
            //找到要删除的节点
            Node targetNode = searchNode(value);
            if (targetNode == null) {
                return;
            }
            //如果发现这个要删除的节点，没有父节点 ,根节点
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }

            //去找targetNode 的父节点
            Node targetParent = searchParent(value);

            // 1. 如果要删除的是叶子节点 ，左右为空
            if (targetNode.left == null && targetNode.right == null) {
                //判断targetNode是父节点，还是左子节点，还是右子节点
                if (targetParent.left != null && targetParent.left.value == value) {
                    targetParent.left = null;
                } else if (targetParent.right != null && targetParent.right.value == value) {
                    targetParent.right = null;
                }
            }
            // 2. 如果要删除2 颗子树 的节点
            else if (targetNode.left != null && targetNode.right != null) {
                //返回的最小值
                int minValue = deleteRightTreeMin(targetNode.right);
                targetNode.value = minValue;
            }
            // 3. 如果要删除 1 颗子树 的节点
            else {
                //注意这里的 bug ，
                if (targetNode.left != null) {
                    if (targetParent != null) {
                        if (targetParent.left.value == value) {
                            targetParent.left = targetNode.left;
                        } else {
                            targetParent.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }
                }
                //要删除的节点有右子节点
                else {
                    if (targetParent != null) {
                        if (targetParent.left.value == value) {
                            targetParent.left = targetNode.right;
                        } else {
                            targetParent.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
                    }
                }
            }
        }
    }

    /**
     * @param node
     * @return 返回的是最小的值
     */
    public int deleteRightTreeMin(Node node) {
        Node target = node;
        //循环的查找node 的最小值 ，就会找到最小值
        while (target.left != null) {
            target = target.left;
        }
        //这时target就指向最小值,删除
        deleteNode(target.value);
        return target.value;
    }

    /**
     * @param value
     * @return
     */
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    /**
     * 查询要删除的节点
     *
     * @param value
     * @return
     */
    public Node searchNode(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchNode(value);
        }
    }

    /**
     * 添加
     *
     * @param node
     */
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    //中序遍历
    public void infixOrder() {
        if (root != null)
            root.infixOrder();
        else
            System.out.println("当前树为空");
    }
}

class Node {
    int value;
    Node left;
    Node right;

    //左旋转方法
    private void leftRotate(){
        //创建新的节点，以当前根节点的值
        Node newNode=new Node(value);
        //把新的节点的左子树设置成当前节点的左子树
        newNode.left=left;
        //把新的节点的右子树设置成当前节点的右子树的左子树
        newNode.right=right.left;
        //把当前的节点的值替换成右子节点的值
        value=right.value;
        //把当前节点的右子树设置成右子树的右子树
        right=right.right;
        //把当前节点的左子树（节点）设置成新的节点
        left=newNode;
    }

    private void rightRotate() {
        //创建新的节点，以当前根节点的值
        Node newNode = new Node(value);
        //
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
    }

    //返回左子树的高度
    public int leftHeight() {
        return (left == null ? 0 : left.height());
    }

    //返回左子树的高度
    public int rightHeight() {
        return (right == null ? 0 : right.height());
    }

    //返回当前节点以根节点的 树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }


    /**
     * 查询节点
     *
     * @param value 要查找的值
     * @return
     */
    public Node searchNode(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            if (this.left == null) {
                return null;
            }
            return this.left.searchNode(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.searchNode(value);
        }
    }

    /**
     * 查询父节点
     *
     * @param value 要找到的值
     * @return 返回 要删除 的父节点， 没有则为空
     */
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            //向左子树递归查找
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            }
            //向右子树递归查找
            else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
    }

    //添加节点
    //递归方式添加节点，需要满足二叉排序树的需求
    public void add(Node node) {
        if (node == null) {
            return;
        }
        //判断要添加的节点，是否比当前的节点的值小
        if (node.value < this.value) {
            //如果当前节点的左指节点为空
            if (this.left == null) {
                this.left = node;
            }
            //则递归向左节点添加
            else {
                this.left.add(node);
            }
        }
        //大
        else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }

        //当添加完一个节点后，如果 ：右子树的高度值 - 左子树的高度值 >1
        if (rightHeight()-leftHeight()>1) {
            //旋转规则
            //如果右子树的左子树的高度大于右子树的高度，则先右旋转了再左旋转
            if (right != null && right.leftHeight()<right.rightHeight()) {
                //先对右子树进行旋转
                right.rightRotate();
                leftRotate();
            }
            else {
                leftRotate();
            }
            //添加一个节点处理一个节点，这样不会出问题，不会再继续往下判断
            return;
        }
        if (leftHeight()-rightHeight()>1){
            //右旋转
            if (left!=null && left.rightHeight()> left.leftHeight()){
                //先判定左子树的右节点是否比左节点高，如果高了则先先旋转了，再右旋转
                left.leftRotate();
                rightRotate();
            }
           else {
               //否则直接右旋转
                rightRotate();
            }
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //构造参数
    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}