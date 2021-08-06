package LCNQ;

import java.util.Arrays;

public class LC300 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int res = 0;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for(int i = 1;i < len;i++) {
            for(int j = 0;j < i;j++) {
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
