package LCNQ;

public class LC526 {
    Integer res = 0;
    public int countArrangement(int n) {
        boolean[] vis = new boolean[n + 1];
        dfs(vis, 1);
        return res;
    }

    public void dfs(boolean[] vis, int cur) {
        if(cur == vis.length) {
            res++;
            return;
        }
        for(int i = 1;i < vis.length;i++) {
            if(!vis[i] && (i % cur == 0 || cur % i == 0)) {
                vis[i] = true;
                dfs(vis, cur + 1);
                vis[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new LC526().countArrangement(4));
    }
}
