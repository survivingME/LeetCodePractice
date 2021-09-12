package LCNQ;

import Domain.TreeNode;

public class LC104 {
    public int maxDepth(TreeNode root) {
        return findDepth(root, 1);
    }

    public int findDepth(TreeNode node, int level) {
        if(node != null) {
            int d1 = findDepth(node.left, level + 1);
            int d2 = findDepth(node.right, level + 1);
            return Math.max(d1, d2);
        }
        return level - 1;
    }
}
