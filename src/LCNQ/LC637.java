package LCNQ;

import Domain.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class LC637 {
    public List<Integer> averageOfLevels(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        list.add(root);
        bfs(list, res, 0);
        return res;
    }

    public void bfs(LinkedList<TreeNode> list, List<Integer> res, int level) {
        if(list == null || list.size() == 0) return;
        res.add(list.get(list.size() - 1 - level).val);
        LinkedList<TreeNode> nlist = new LinkedList<>();
        while(!list.isEmpty()) {
            TreeNode node = list.poll();
            if(node.left != null) nlist.add(node.left);
            if(node.right != null) nlist.add(node.right);
        }
        bfs(nlist, res, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        List<Integer> integers = new LC637().averageOfLevels(root);
        System.out.println(integers);
    }
}
