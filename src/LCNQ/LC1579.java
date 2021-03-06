package LCNQ;

import java.util.Arrays;

public class LC1579 {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind ufa = new UnionFind(n);
        UnionFind ufb = new UnionFind(n);
        int ans = 0;
        for (int[] edge : edges) {
            edge[1]--;
            edge[2]--;
        }
        for (int[] edge : edges) {
            if(edge[0] == 3) {
                if(!ufa.union(edge[1], edge[2])) {
                    ans++;
                } else {
                    ufb.union(edge[1], edge[2]);
                }
            }
        }
        for (int[] edge : edges) {
            if(edge[0] == 1) {
                if(!ufa.union(edge[1], edge[2])) ans++;
            }
            if(edge[0] == 2) {
                if(!ufb.union(edge[1], edge[2])) ans++;
            }
        }
        if(ufa.setCount != 1 || ufb.setCount != 1) return -1;
        return ans;
    }
    class UnionFind{
        int[] parent;
        int[] size;
        int n;
        int setCount;
        public UnionFind(int n) {
            this.n = n;
            this.setCount = n;
            this.parent = new int[n];
            this.size = new int[n];
            Arrays.fill(size, 1);
            for(int i = 0;i < n;i++) parent[i] = i;
        }

        public int find(int x) {
            if(parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            x = find(x);
            y = find(y);
            if(x == y) return false;
            if(size[x] < size[y]) {
                int temp = x;
                x = y;
                y = temp;
            }
            parent[y] = x;
            size[x] += size[y];
            setCount--;
            return true;
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}

