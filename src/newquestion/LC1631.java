package newquestion;

import java.util.*;

public class LC1631 {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int len = m * n;
        int[] parent = new int[len];
        for(int i = 0;i < len;i++) parent[i] = i;
        List<int[]> edges = new ArrayList<>();
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                int idx = i * n + j;
                if(i > 0) {
                    edges.add(new int[]{idx - n, idx, Math.abs(heights[i][j] - heights[i - 1][j])});
                }
                if(j > 0) {
                    edges.add(new int[]{idx - 1, idx, Math.abs(heights[i][j] - heights[i][j - 1])});
                }
            }
        }
        Collections.sort(edges, Comparator.comparingInt(o -> o[2]));
        for (int[] edge : edges) {
            union(parent, edge[0], edge[1]);
            if(connected(parent, 0, len - 1)) {
                return edge[2];
            }
        }
        return 0;
    }

    public void union(int[] parent, int index1, int index2) {
        int p1 = find(parent, index1), p2 = find(parent, index2);
        if(p1 != p2) {
            if(p1 < p2) {
                int temp = p1;
                p1 = p2;
                p2 = temp;
            }
            parent[p2] = p1;
        }
    }

    public int find(int[] parent, int index) {
        if(parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

    public boolean connected(int[] parent, int index1, int index2) {
        return find(parent, index1) == find(parent, index2);
    }
}
