package LCNQ;

import java.util.TreeSet;

public class LC363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        for(int i = 0;i < m;i++) {
            int[] sum = new int[n];
            for(int j = i;j < m;j++) {
                for(int c = 0;c < n;c++) sum[c] += matrix[j][c];
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int s = 0;
                for (int e : sum) {
                    s += e;
                    Integer ceiling = set.ceiling(s - k);
                    if(ceiling != null) ans = Math.max(ans, s - ceiling);
                    set.add(s);
                }
            }
        }
        return ans;
    }
}
