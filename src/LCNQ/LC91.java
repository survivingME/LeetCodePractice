package LCNQ;

public class LC91 {
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        if(s.charAt(0) == '0') return 0;
        dp[0] = 1;
        for(int i = 1;i <= len;i++) {
            if(s.charAt(i - 1) != '0') dp[i] += dp[i - 1];
            if(i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0') <= 26) dp[i] += dp[i - 2];
        }
        return dp[len];
    }
}
