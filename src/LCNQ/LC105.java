package LCNQ;

import domain.TreeNode;

import java.util.HashMap;

public class LC105 {
    HashMap<Integer, Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        for(int i = 0;i < len;i++) inorderMap.put(inorder[i], i);
        return build(preorder, 0, len - 1, 0, len - 1);
    }

    public TreeNode build(int[] preorder, int preLeft, int preRight, int inLeft, int inRight) {
        if(preLeft > preRight) return null;
        TreeNode root = new TreeNode(preorder[preLeft]);
        int inRoot = inorderMap.get(preorder[preLeft]);
        int leftLen = inRoot - inLeft;
        root.left = build(preorder, preLeft + 1, preLeft + leftLen, inLeft, inRoot - 1);
        root.right = build(preorder, preLeft + leftLen + 1, preRight, inRoot + 1, inRight);
        return root;
    }
}
