package LCNQ;

public class LC198 {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        if(len > 1) dp[1] = Math.max(dp[0], nums[1]);
        for(int i = 2;i < len;i++) dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        return dp[len - 1];
    }
}
