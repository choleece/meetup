package cn.choleece.tree;

/**
 * @author choleece
 * @description: cn.choleece.tree
 * @date 2018/6/11 9:53
 */
public class Node {
    public int val;

    public Node left;

    public Node right;

    public Node(int val) {
        this(val, null, null);
    }

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void showNode() {
        System.out.println("val: " + val);
    }
}
