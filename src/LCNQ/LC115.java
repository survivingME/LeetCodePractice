package LCNQ;

public class LC115 {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0;i < m;i++) dp[i][0] = 1;
        for(int i = 1;i < m;i++) {
            char sc = s.charAt(i - 1);
            for(int j = 1;j < n;j++) {
                char tc = t.charAt(j - 1);
                if (sc == tc) dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[m][n];
    }
}


