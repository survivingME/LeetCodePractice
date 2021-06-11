package LCNQ;

public class LC279 {
    public int numSquares(int n) {
        int len = (int) Math.sqrt(n);
        if(len * len == n) return 1;
        int[] dp = new int[n + 1];
        for(int i = 0;i <= n;i++) dp[i] = i;
        for(int i = 2;i <= len;i++) {
            for(int j = i * i;j <= n;j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new LC279().numSquares(13));
    }
}
