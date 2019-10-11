package com.test.bianrysorttree;

/**
 * 二叉排序树 134节
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10};
        BinarySortTree binarySortTree = new BinarySortTree();

        //循环添加二叉树
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
        System.out.println("-------------删除前------------");
        binarySortTree.infixOrder();
        //测试 1. 删除叶子节点
        binarySortTree.deleteNode(7);
        binarySortTree.deleteNode(10);
        binarySortTree.deleteNode(3);
        //测试 2. 删除只有一颗子树的节点
        //测试 2. 删除有 2 颗子树的节点
        System.out.println("-------------删除后------------");
        binarySortTree.infixOrder();
    }
}

class BinarySortTree {
    private Node root;

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