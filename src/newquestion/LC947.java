package newquestion;

import java.util.Arrays;

public class LC947 {
    public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind();
        int n = stones.length;
        for(int i = 0;i < n;i++) {
            uf.union(stones[i][0], stones[i][1] + 10000);
        }
        return n - uf.count();
    }

    class UnionFind {
        int[] f;
        int[] rank;

        public UnionFind() {
            f = new int[20000];
            rank = new int[20000];
            Arrays.fill(f, -1);
            Arrays.fill(rank, -1);
        }

        public int find(int x) {
            if(f[x]< 0) {
                f[x] = x;
                rank[x] = 1;
            } else if(f[x] != x) {
                f[x] = find(f[x]);
            }
            return f[x];
        }

        public void union(int x, int y) {
            int fx = find(x), fy = find(y);
            if(fx == fy) return ;
            if(rank[fx] < rank[fy]) {
                int tmp = fx;
                fx = fy;
                fy = tmp;
            }
            rank[fx] += rank[fy];
            f[fy] = fx;
        }

        public int count() {
            int num = 0;
            for(int i = 0;i < 20000;i++) {
                if(f[i] == i) num++;
            }
            return num;
        }
    }
}
