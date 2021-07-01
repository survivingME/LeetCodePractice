package LCNQ;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LCP07 {
    //dfs到固定层数，判断是否为target
    //bfs到固定层数，跳出bfs，判断队列中是否有target
    int n, k, ans;
    HashMap<Integer, HashSet<Integer>> map;
    public int numWays(int n, int[][] relation, int k) {
        this.n = n;
        this.k = k;
        this.ans = 0;
        this.map = new HashMap<>();
        for (int[] edge : relation) {
            int a = edge[0], b = edge[1];
            HashSet<Integer> set = map.getOrDefault(a, new HashSet<>());
            set.add(b);
            map.put(a, set);
        }
        dfs(0, 0);
        return ans;
    }

    void dfs(int u, int l) {
        if(l == k) {
            if(u == n - 1) ans++;
            return;
        }
        HashSet<Integer> set = map.get(u);
        if(set != null) for (Integer next : set) dfs(next, l + 1);
    }
}
