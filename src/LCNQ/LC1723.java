package LCNQ;

public class LC1723 {
    int ans = Integer.MAX_VALUE;
    public int minimumTimeRequired(int[] jobs, int k) {
        int[] workers = new int[k];
        bt(jobs, workers, 0, 0, 0);
        return ans;
    }

    public void bt(int[] jobs, int[] workers, int cur, int vis,int max) {
        if(max > ans) return;
        if(cur == jobs.length) {
            ans = max;
            return;
        }
        if(vis < workers.length) {
            workers[vis] = jobs[cur];
            bt(jobs, workers, cur + 1, vis + 1, Math.max(max, workers[vis]));
            workers[vis] = 0;
        }
        for(int i = 0; i < vis;i++) {
            workers[i] += jobs[cur];
            bt(jobs, workers, cur + 1, vis, Math.max(max, workers[i]));
            workers[i] -= jobs[cur];
        }
    }
}
