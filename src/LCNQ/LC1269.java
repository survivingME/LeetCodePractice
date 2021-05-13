package LCNQ;

public class LC1269 {
    public int numWays(int steps, int arrLen) {
        int mod = (int)1e9 + 7;
        int max = Math.min(steps / 2, arrLen - 1);
        int[][] dp = new int[steps + 1][max + 1];
        dp[steps][0] = 1;
        for(int i = steps - 1;i >= 0;i--) {
            int max1 = Math.min(i, max);
            for(int j = 0;j <= max1;j++) {
                dp[i][j] = (dp[i][j] + dp[i + 1][j]) % mod;
                if(j < max) dp[i][j] = (dp[i][j] + dp[i + 1][j + 1]) % mod;
                if(j > 0) dp[i][j] = (dp[i][j] + dp[i + 1][j - 1]) % mod;
            }
        }
        return dp[0][0];
    }

    /**
     * dp[i][j] 表示剩余可移动次数i，位置在j时的方案数
     * dp[step][0] = 1 没移动的时候在原点，方案数为1
     * 可移动位置取决于数组长度和可移动次数 / 2 (再不往回走就回不去了) Math.min(step / 2, arrLen - 1)
     * 由于可以不动、左移、右移一步，所以：
     * dp[i][j] = dp[i + 1][j] + dp[i + 1][j + 1] + dp[i + 1][j - 1] 这里注意左移右移的边界条件
     * 优化：由于随着可移动次数的减少，在可移动次数为i的情况下，其最远移动距离为 Math.min(i, max)，减少无用计算
     */
}
