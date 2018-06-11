package cn.choleece.tree;

/**
 * @author choleece
 * @description: cn.choleece.tree
 * @date 2018/6/11 10:00
 */
public class BinarySearchTree {
    private Node root;

    public void put(int val) {
        root = put(root, val);
    }

    public Node put(Node x, int val) {
        if (x == null) {
            return new Node(val);
        }
        if (val > x.val) {
            x.right = put(x.right, val);
        } else if (val < x.val) {
            x.left = put(x.left, val);
        } else {
            x.val = val;
        }
        return x;
    }
}
