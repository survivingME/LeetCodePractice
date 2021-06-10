package LCNQ;

public class LC518 {
    public int change(int amount, int[] coins) {
        if(amount == 0) return 1;
        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
        for(int i = 1;i <= len;i++) {
            for(int j = 1;j <= amount;j++) {
                if(j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else if(j == coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[len + 1][amount];
    }

    public int change100p(int amount, int[] coins) {
        if(coins == null) return 0;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for(int i = coin;i <= amount;i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
