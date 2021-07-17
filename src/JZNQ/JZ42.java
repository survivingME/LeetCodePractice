package JZNQ;

public class JZ42 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int dp = nums[0];
        int res = dp;
        for(int i = 1;i < len;i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            res = Math.max(res, dp);
        }
        return res;
    }
}
