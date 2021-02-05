package LCNQ;

public class LC684 {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        for(int i = 0;i < parent.length;i++) parent[i] = i;
        for (int i = 0; i < edges.length; i++) {
            int index1 = edges[i][0], index2 = edges[i][1];
            if(parent(parent, index1) != parent(parent, index2)) {
                union(parent, index1, index2);
            } else {
                return edges[i];
            }
        }
        return new int[2];
    }

    public void union(int[] parent, int index1, int index2) {
        parent[parent(parent, index1)] = parent(parent, index2);
    }

    public int parent(int[] parent, int index) {
        if(parent[index] != index) {
            parent[index] = parent(parent, parent[index]);
        }
        return parent[index];
    }
}
