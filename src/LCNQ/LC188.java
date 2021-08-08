package LCNQ;

public class LC188 {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) {
            int dp0 = 0, dp1 = Integer.MIN_VALUE;
            for (int price : prices) {
                int tmp = dp0;
                dp0 = Math.max(dp0, dp1 + price);
                dp1 = Math.max(dp1, tmp - price);
            }
            return dp0;
        } else {
            int[][][] dp = new int[len][k + 1][2];
            for(int i = 0;i < len;i++) {
                for(int j = 1;j <= k;j++) {
                    if(i == 0) {
                        dp[i][j][0] = 0;
                        dp[i][j][1] = -prices[i];
                    } else {
                        dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                        dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i][j - 1][0] - prices[i]);
                    }
                }
            }
            return dp[len-1][k][0];
        }
    }
}
