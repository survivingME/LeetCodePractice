package LCNQ;

import domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        if(root1 == null && root2 == null) return true;
        btLeaf(root1, list1);
        btLeaf(root2, list2);
        if(list1.size() != list2.size()) return false;
        for (int i = 0; i < list1.size(); i++) {
            if(list1.get(i) != list2.get(i)) return false;
        }
        return true;
    }

    public void btLeaf(TreeNode root, List<Integer> list) {
        if(root == null) return;
        btLeaf(root.left, list);
        if(root.left == null && root.right == null) list.add(root.val);
        btLeaf(root.right, list);
    }
}
