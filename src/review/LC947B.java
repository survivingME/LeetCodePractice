package review;

import java.util.HashSet;
import java.util.Set;

public class LC947B {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        if(n <= 1) return 0;
        int max = 0;
        for (int[] stone : stones) max = Math.max(max, Math.max(stone[0], stone[1]) + 1);
        int[] parent = new int[max * 2];
        for(int i = 0;i < max * 2;i++) parent[i] = i;
        for (int[] stone : stones) {
            union(parent, stone[0], stone[1] + max);
        }
        Set<Integer> set = new HashSet<>();
        for (int[] stone : stones) {
            set.add(find(parent, stone[0]));
        }
        return n - set.size();
    }

    public void union(int[] parent, int r, int c) {
        int ra = find(parent, r), ca = find(parent, c);
        if(ra == ca) return;
        parent[ca] = ra;
    }

    public int find(int[] parent, int start) {
        int ancestor = start, cur = start;
        while(ancestor != parent[ancestor]) ancestor = parent[ancestor];
        while(cur != parent[cur]) {
            int curParent = parent[cur];
            parent[cur] = ancestor;
            cur = curParent;
        }
        return ancestor;
    }
}
