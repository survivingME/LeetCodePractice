package LCNQ;

import java.util.Arrays;

public class LC787 {
//    boolean[][] vis;
//    int[][] cost;
//    int res = Integer.MAX_VALUE;
//    int dst;
//    int K;
//    int N;
//    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//        this.dst = dst;
//        this.N = n;
//        this.K = k;
//        vis = new boolean[n][n];
//        cost = new int[n][n];
//        for(int[] flight : flights) {
//            cost[flight[0]][flight[1]] = flight[2];
//            vis[flight[0]][flight[1]] = false;
//        }
//        dfs(src, 0, 0);
//        return res;
//    }
//
//    public void dfs(int cur, int curL, int curC) {
//        if(curL <= K) {
//            if(cur == dst) {
//                res = Math.min(res, curC);
//                return ;
//            }
//            for(int i = 0;i < N;i++) {
//                if(cost[cur][i] != 0 && !vis[cur][i]) {
//                    vis[cur][i] = true;
//                    dfs(i, curL + 1, curC + cost[cur][i]);
//                    vis[cur][i] = false;
//                }
//            }
//        }
//    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = 10000 * 101 + 1;
        int[] dp = new int[n];
        Arrays.fill(dp, INF);
        dp[src] = 0;
        for(int i = 1;i <= k + 1;i++) {
            int[] ndp = new int[n];
            for (int[] flight : flights) {
                int a = flight[0], b = flight[1], cost = flight[2];
                ndp[b] = Math.min(ndp[b], dp[a] + cost);
            }
            dp = ndp;
        }
        int res = INF;
        for(int i = 1;i <= k + 1;i++) res = Math.min(res, dp[dst]);
        if(res == INF) return -1;
        return res;
    }
}
