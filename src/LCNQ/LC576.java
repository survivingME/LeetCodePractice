package LCNQ;

public class LC576 {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int MOD = (int)Math.pow(10, 9) + 7;
        int[] d = new int[]{-1, 0, 1, 0, -1};
        int res = 0;
        int[][] dp = new int[m][n];
        dp[startRow][startColumn] = 1;
        for(int i = 0;i < maxMove;i++) {
            int[][] ndp = new int[m][n];
            for(int a = 0;a < m;a++) {
                for(int b = 0;b < n;b++) {
                    int count = dp[a][b];
                    if(count > 0) {
                        for(int o = 0;o < 4;o++) {
                            int nx = a + d[o], ny = b + d[o + 1];
                            if(nx >= 0 && nx < m && ny >= 0 && ny < n) {
                                ndp[nx][ny] = (ndp[nx][ny] + count) % MOD;
                            } else {
                                res = (res + count) % MOD;
                            }
                        }
                    }
                }
            }
            dp = ndp;
        }
        return res;
    }
}
