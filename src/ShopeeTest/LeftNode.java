package ShopeeTest;

import Domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeftNode {
    public void leftNode(TreeNode root) {
        if(root == null) return ;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if(poll.left != null) {
                System.out.println(poll.left.val);
                queue.add(poll.left);
            }
            if(poll.right != null) queue.add(poll.right);
        }
    }

    public void leftNodeC(TreeNode root) {
        if(root == null) return;
        if(root.left != null) {
            System.out.println(root.left.val);
            leftNodeC(root.left);
        }
        if(root.right != null) leftNodeC(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.left.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);
        root.left.right.left.left = new TreeNode(11);
        root.left.right.right = new TreeNode(9);
        root.right.left.left = new TreeNode(10);
        root.right.left.left.left = new TreeNode(12);
        new LeftNode().leftNode(root);
    }
}
