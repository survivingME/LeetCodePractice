package LCNQ;

import Domain.TreeNode;

public class LC450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        //查找过程
        if(root.val > key) root.left = deleteNode(root.left, key);
        else if(root.val < key) root.right = deleteNode(root.right, key);
        //两边都不为空，选左子树中最大值进行替换，并删除左子树中这个节点
        else if(root.left != null && root.right != null) {
            int val = findMax(root.left);
            root.val = val;
            root.left = deleteNode(root.left, val);
        }
        //有一边为空，使用不空那边的子树顶节点替换
        else if(root.left != null) root = root.left;
        else if(root.right != null) root = root.right;
        //没有子节点，直接置为null
        else root = null;
        return root;
    }
    //找左子树中最大值
    public int findMax(TreeNode node) {
        if(node.right != null) return findMax(node.right);
        else return node.val;
    }
}
