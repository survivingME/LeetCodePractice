package newquestion;

public class LC959 {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int len = n * n * 4;
        int[] parent = new int[len];
        for(int i = 0;i < len;i++) parent[i] = i;
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < n;j++) {
                int idx = i * n + j;
                //上下两区域的2和0一定连通
                if(i < n - 1) {
                    int bottom = idx + n;
                    merge(parent, idx * 4 + 2, bottom * 4);
                }
                //左右两区域的1和3一定连通
                if(j < n - 1) {
                    int right = idx + 1;
                    merge(parent, idx * 4 + 1, right * 4 + 3);
                }
                //右斜杆分别把0,3和1,2连通在一起
                if(grid[i].charAt(j) == '/') {
                    merge(parent, idx * 4, idx * 4 + 3);
                    merge(parent, idx * 4 + 1, idx * 4 + 2);
                //左斜杆分别把0,1和2,3连通在一起
                } else if(grid[i].charAt(j) == '\\') {
                    merge(parent, idx * 4, idx * 4 + 1);
                    merge(parent, idx * 4 + 2, idx * 4 + 3);
                //全部连通
                } else {
                    merge(parent, idx * 4, idx * 4 + 1);
                    merge(parent, idx * 4 + 1, idx * 4 + 2);
                    merge(parent, idx * 4 + 2, idx * 4 + 3);
                }
            }
        }
        //计算连通区域，一般是建立一个set，然后对于每个点find它的最终parent，将这个parent放入set中最后返回set.size
        //更好的办法是找parent数组中i==parent[i]的点的数量（原理一样，但效率更高）
        int res = 0;
        for(int i = 0;i < len;i++) {
            if(i == parent[i]) res++;
        }
        return res;
    }

    public int find(int[] parent, int index) {
        if(parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

    public void merge(int[] parent, int index1, int index2) {
        int f1 = find(parent, index1), f2 = find(parent, index2);
        parent[f1] = f2;
    }
}
