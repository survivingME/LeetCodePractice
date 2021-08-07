package LCNQ;

import domain.TreeNode;

public class LC108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        return arrToBST(nums, 0, len - 1);
    }

    public TreeNode arrToBST(int[] nums, int left, int right) {
        if(left > right) return null;
        else if(left == right) return new TreeNode(nums[left]);
        else {
            int mid = (left + right) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = arrToBST(nums, left, mid - 1);
            node.right = arrToBST(nums, mid + 1, right);
            return node;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode treeNode = new LC108().sortedArrayToBST(nums);
    }
}
