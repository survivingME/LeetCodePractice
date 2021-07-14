package test;

import domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedTransferQueue;

public class TestMakeTree {
    public TreeNode makeTree(Integer[] arr) {
        if(arr == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        queue.add(root);
        int cur = 1;
        while(cur < arr.length) {
            TreeNode poll = queue.poll();
            if(arr[cur] != null) {
                poll.left = new TreeNode(arr[cur]);
                queue.add(poll.left);
            }
            cur++;
            if(cur == arr.length) break;
            if(arr[cur] != null) {
                poll.right = new TreeNode(arr[cur]);
                queue.add(poll.right);
            }
            cur++;
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[6];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = null;
        arr[3] = 3;
        arr[4] = 4;
        arr[5] = 5;
        TreeNode root = new TestMakeTree().makeTree(arr);
    }
}
