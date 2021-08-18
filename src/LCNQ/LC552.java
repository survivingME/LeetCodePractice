package LCNQ;

import java.util.LinkedList;
import java.util.List;

public class LC552 {
    int MOD = (int) Math.pow(10, 9) + 7;
    int res = 0;
    int len = 0;
    boolean af = true;
    public int checkRecord(int n) {
        int[][] dp = new int[2][3];
        dp[0][0] = 1;
        for(int i = 1;i <= n;i++) {
            int[][] ndp = new int[2][3];
            for(int a = 0;a < 2;a++) {
                for(int b = 0;b < 3;b++) {
                    ndp[a][0] = (ndp[a][0] + dp[a][b]) % MOD;
                }
            }
            for(int a = 0;a < 3;a++) {
                ndp[1][0] = (ndp[1][0] + dp[0][a]) % MOD;
            }

            for(int a = 0;a < 2;a++) {
                for(int b = 1;b < 3;b++) {
                    ndp[a][b] = (ndp[a][b] + dp[a][b - 1]) % MOD;
                }
            }
            dp = ndp;
        }
        for(int a = 0;a < 2;a++) {
            for(int b = 0;b < 3;b++) res = (res + dp[a][b]) % MOD;
        }
        return res;
    }

    public void dfs(List<Character> cur) {
        if(cur.size() == len) {
           res++;
           if(res == MOD) res = 0;
           return;
        }
        cur.add('P');
        dfs(cur);
        cur.remove(cur.size() - 1);

        if(af) {
            cur.add('A');
            af = false;
            dfs(cur);
            cur.remove(cur.size() - 1);
            af = true;
        }

        if(cur.size() < 2 || (cur.get(cur.size() - 1) != 'L' && cur.get(cur.size() - 2) != 'L')) {
            cur.add('L');
            dfs(cur);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LC552().checkRecord(10101));
    }
}
