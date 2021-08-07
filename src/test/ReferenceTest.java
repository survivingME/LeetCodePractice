package test;

import domain.TreeNode;

public class ReferenceTest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(100);
        test(root);
        System.out.println(root.val);
    }

    public static void test(TreeNode node) {
        node = new TreeNode(12);
        System.out.println(node.val);
    }
}
