package LCNQ;

import Domain.TreeNode;

public class LC671 {
    int ans = -1, rootVal;
    public int findSecondMinimumValue(TreeNode root) {
        if(root.left == null) return -1;
        rootVal = root.val;
        find(root);
        return ans;
    }

    /**
     * 遍历整个树，如果ans已改动且比当前node.val小，直接返回；否则node.val大于rootVal时，修改ans。
     * @param node
     */
    public void find(TreeNode node) {
        if(node == null) return ;
        if(ans != -1 && node.val > ans) return;
        if(node.val > rootVal) ans = node.val;
        find(node.left);
        find(node.right);
    }
}
