package LCNQ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LC1584 {
    class Edge {
        int a, b, val;
        public Edge(int a, int b, int val) {
            this.a = a;
            this.b = b;
            this.val = val;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int len = points.length;
        int[] parent = new int[len];
        for(int i = 0;i < len;i++) parent[i] = i;
        List<Edge> list = new ArrayList<>();
        //构建所有边
        for(int i = 0;i < len - 1;i++) {
            for(int j = i + 1;j < len;j++) {
                list.add(new Edge(i, j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])));
            }
        }
        //从小到大排序
        Collections.sort(list, Comparator.comparingInt(a -> a.val));
        int res = 0;
        //通过并查集判断是否连通，如果没连通就构建连通，并将边长加入结果
        for (Edge edge : list) {
            int a = find(parent, edge.a), b = find(parent, edge.b);
            if(a != b) {
                parent[a] = b;
                res += edge.val;
            }
        }
        return res;
    }

    public int find(int[] parent, int index) {
        if(parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }
}
