package review;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC1631 {
    public int minimumEffortPath(int[][] heights) {
        int[] d = new int[]{-1, 0, 1, 0, -1};
        int m = heights.length, n = heights[0].length;
        int len = m * n;
        boolean[] vis = new boolean[len];
        int[] dis = new int[len];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        queue.add(new int[]{0, 0, 0});
        while(!queue.isEmpty()) {
            int[] edge = queue.poll();
            int x = edge[0], y = edge[1], ed = edge[2];
            if(x == m - 1 && y == n - 1) break;
            int idx = x * n + y;
            if(vis[idx]) continue;
            vis[idx] = true;
            for(int i = 0;i < 4;i++) {
                int nx = x + d[i], ny = y + d[i + 1];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int nidx = nx * n + ny;
                    int curdis = Math.max(ed, Math.abs(heights[x][y] - heights[nx][ny]));
                    if(curdis < dis[nidx]) {
                        dis[nidx] = curdis;
                        queue.add(new int[]{nx, ny, dis[nidx]});
                    }
                }
            }
        }
        return dis[len - 1];
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,2},{3,8,2},{5,3,5}};
        int i = new LC1631().minimumEffortPath(arr);
        System.out.println(i);
    }
}
