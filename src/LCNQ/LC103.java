package LCNQ;

import Domain.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        List<Integer> cur = new LinkedList<>();
        queue.add(root);
        cur.add(root.val);
        res.add(new LinkedList<>(cur));
        boolean right = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            cur = new LinkedList<>();
            for(int i = 0;i < size;i++) {
                TreeNode poll = queue.poll();
                if(poll.left != null) {
                    queue.add(poll.left);
                    cur.add(poll.left.val);
                }
                if(poll.right != null) {
                    queue.add(poll.right);
                    cur.add(poll.right.val);
                }
            }
            if(cur.size() > 0) {
                if(right) {
                    Collections.reverse(cur);
                }
                res.add(new LinkedList<>(cur));
                right = !right;
            }
        }
        return res;
    }
}
