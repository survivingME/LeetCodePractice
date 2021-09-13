package LCNQ;

import Domain.TreeNode;

public class LC114 {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while(cur != null) {
            if(cur.left != null) {
                TreeNode next = cur.left;
                TreeNode prev = next;
                while(prev.right !=null) prev = prev.right;
                prev.right = cur.right;
                cur.left = null;
                cur.right = next;
            }
            cur = cur.right;
        }
    }
}
