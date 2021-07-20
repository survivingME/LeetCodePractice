package LCNQ;

import java.util.Arrays;

public class LC1877 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int l = 0, r = len - 1;
        int res = 0;
        while(l < r) {
            res = Math.max(res, nums[l] + nums[r]);
            l++;
            r--;
        }
        return res;
    }
}
