package LCNQ;

import domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC37 {
    // Encodes a tree to a single string.
    int INF = -10000;
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if(poll == null) {
                sb.append(INF).append("_");
            }  else {
                sb.append(poll.val).append("_");
                queue.add(poll.left);
                queue.add(poll.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        String[] arr = data.split("_");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for(int i = 1;i < arr.length - 1;i += 2) {
            TreeNode poll = queue.poll();
            int a = Integer.parseInt(arr[i]), b = Integer.parseInt(arr[i + 1]);
            if(a != INF) {
                poll.left = new TreeNode(a);
                queue.add(poll.left);
            }
            if(b != INF) {
                poll.right = new TreeNode(b);
                queue.add(poll.right);
            }
        }
        return root;
    }
}
