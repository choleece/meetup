package cn.choleece.tree;

import java.nio.BufferUnderflowException;

/**
 * @author choleece
 * @description: cn.choleece.tree
 * @date 2018/6/11 10:00
 */
public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(int x) {
        return contains(x, root);
    }

    private boolean contains(int x, Node root) {
        if (root == null) {
            return false;
        }
        if (x < root.val) {
            return contains(x, root.left);
        } else if (x > root.val) {
            return contains(x, root.right);
        } else {
            return true;
        }
    }

    public int findMin() {
        if (isEmpty()) {
            throw new BufferUnderflowException();
        }
        return findMin(root).val;
    }

    private Node findMin(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root;
        }
        return findMin(root.left);
    }

    public int findMax() {
        if (isEmpty()) {
            throw new BufferUnderflowException();
        }
        return findMax(root).val;
    }

    private Node findMax(Node root) {
        if (root != null) {
            while (root.right != null) {
                root = root.right;
            }
        }
        return root;
    }

    public void insert(int val) {
        root = insert(val, root);
    }

    private Node insert(int val, Node root) {
        if (root == null) {
            return new Node(val);
        }
        if (val > root.val) {
            root.right = insert(val, root.right);
        } else if (val < root.val) {
            root.left = insert(val, root.left);
        } else {
            root.val = val;
        }
        return root;
    }

    public void printTree() {
        if (isEmpty()) {
            System.out.println("empty tree..");
        } else {
            printTree(root);
        }
    }

    public void remove(int val) {
        remove(val, root);
    }

    private Node remove(int val, Node root) {
        if (root == null) {
//            节点为空，什么也不做
            return root;
        }
        if (val < root.val) {
            root.left = remove(val, root.left);
        } else if (val > root.val) {
            root.right = remove(val, root);
        } else if (root.right != null && root.left != null) {
//            此节点有两个孩子
            root.val = findMin(root.right).val;
            root.right = remove(root.val, root.right);
        } else {
//            此节点只有一个孩子或者一个孩子都没有
            root = (root.left != null) ? root.left : root.right;
        }
        return root;
    }

    private void printTree(Node root) {
        if (root != null) {
            System.out.println(root.val);
            printTree(root.left);
            printTree(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(12);
        tree.insert(6);
        tree.insert(14);
        tree.insert(4);
        tree.insert(8);
        tree.insert(7);
        tree.insert(9);
        tree.printTree();
        tree.remove(6);
        tree.printTree();
    }
}
