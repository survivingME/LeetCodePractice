package LCNQ;

import Domain.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        List<Integer> cur = new LinkedList<>();
        queue.add(root);
        cur.add(root.val);
        res.add(new LinkedList<>(cur));
        while(!queue.isEmpty()) {
            cur = new LinkedList<>();
            int size = queue.size();
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
            if(cur.size() > 0) res.add(new LinkedList<>(cur));
        }
        return res;
    }
}
