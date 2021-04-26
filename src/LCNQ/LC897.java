package LCNQ;

import domain.TreeNode;

public class LC897 {
    TreeNode res = new TreeNode(-1);
    TreeNode cur = res;
    public TreeNode increasingBST(TreeNode root) {
        order(root);
        return res.right;
    }

    public void order(TreeNode root) {
        if(root == null) return;
        order(root.left);
        cur.right = new TreeNode(root.val);
        cur = cur.right;
        order(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);
        new LC897().increasingBST(root);
    }
}
