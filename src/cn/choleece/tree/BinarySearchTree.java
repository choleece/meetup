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

    private void printTree(Node root) {
        if (root != null) {
            printTree(root.right);
            printTree(root.left);
            System.out.println(root.val);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(1);
        tree.insert(4);
        tree.insert(5);
        tree.printTree();
    }
}
