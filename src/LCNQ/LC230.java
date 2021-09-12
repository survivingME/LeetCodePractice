package LCNQ;

import Domain.TreeNode;

import java.util.LinkedList;

public class LC230 {
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(true) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.poll();
            if(--k == 0) return root.val;
            root = root.right;
        }
    }
}
