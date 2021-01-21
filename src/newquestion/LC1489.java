package newquestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LC1489 {
    // 定义边
    class Edge {
        // 分别表示当前边的序号、起点、终点、权重
        public int id, a, b, weight;
        public Edge(int i, int _a, int _b, int w) {
            id = i;
            a = _a;
            b = _b;
            weight = w;
        }
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        // 并查集集合初始化
        List<Integer> p = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            p.add(i);
        }

        // 将所有边添加到集合当中
        List<Edge> nes = new ArrayList<>();
        for(int i = 0; i < edges.length; i++) {
            nes.add(new Edge(i, edges[i][0], edges[i][1], edges[i][2]));
        }
        // 根据权重从低到高排序
        Collections.sort(nes, (a, b) -> a.weight - b.weight);

        // 第一步，计算最小生成树的权重
        int minTreeWeight = minTreeWeightCal(new ArrayList<>(p), nes, 0);

        // 初始化答案列表
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        // 复制一个临时边集，用于删边操作
        List<Edge> tempEdges = new ArrayList<>(nes);

        // 第二步，先枚举所有边，查看这条边是不是关键边
        for(Edge e : nes) {
            // 如果从边集中删除了这条边，最小生成树的权重发生了变化，说明这是关键边
            tempEdges.remove(e);
            if(minTreeWeight != minTreeWeightCal(new ArrayList<>(p), tempEdges, 0)) {
                res.get(0).add(e.id);
            }
            // 将删去边放回去，并重新排序
            tempEdges.add(e);
            Collections.sort(tempEdges, (a, b) -> a.weight - b.weight);
        }
        // 第三步，再判断每条边是不是伪关键边
        for(Edge e : nes) {
            // 如果当前边是关键边，那就肯定不是伪关键边
            if(res.get(0).contains(e.id)) continue;
            // 如果先连上了这条边，最小生成树的权重还是一样的，说明这是伪关键边
            List<Integer> tp = new ArrayList(p);
            // 连上这条边的两个端点
            tp.set(e.a, e.b);
            // 判断权重
            if(minTreeWeight == minTreeWeightCal(tp, tempEdges, e.weight)) {
                res.get(1).add(e.id);
            }
        }

        return res;

    }

    // Kruskal算法求最小生成树权重
    private int minTreeWeightCal(List<Integer> p, List<Edge> nes, int w) {
        for(Edge e : nes) {
            int a = find(p, e.a), b = find(p, e.b);

            if(a != b) {
                w += e.weight;
                p.set(a, b);
            }
        }

        return w;
    }

    // 并查集模板方法，求当前元素所在集合的根元素
    private int find(List<Integer> p, int x) {
        if(p.get(x) != x) {
            p.set(x, find(p, p.get(x)));
        }

        return p.get(x);
    }
}