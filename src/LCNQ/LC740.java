package LCNQ;

public class LC740 {
    public int deleteAndEarn(int[] nums) {
        int[] cnt = new int[10001];
        int max = 0;
        for (int num : nums) {
            if(num > max) max = num;
            cnt[num]++;
        }
        /**
        int[][] dp = new int[max + 1][2];
        dp[1][0] = 0;
        dp[1][1] = cnt[1];
        for(int i = 2;i <= max;i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + i * cnt[i];
        }
        return Math.max(dp[max][0], dp[max][1]);
        **/
        int[] dp = new int[max + 1];
        dp[1] = cnt[1];
        for(int i = 2;i <= max;i++) dp[i] = Math.max(dp[i - 2] + i * cnt[i], dp[i - 1]);
        return dp[max];
    }
}
