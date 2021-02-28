package JZNQ;

public class JZNQ29 {
    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if(m == 0) return new int[0];
        int n = matrix[0].length;
        int[] res = new int[m * n];
        int a = 0;
        int r1 = 0, r2 = m - 1, c1 = 0, c2 = n - 1;
        while(r1 <= r2 && c1 <= c2) {
            for(int i = c1;i < c2;i++) res[a++] = matrix[r1][i];
            for(int i = r1;i <= r2;i++) res[a++] = matrix[i][c2];
            if(r1 < r2 && c1 < c2) {
                for(int i = c2 - 1;i > c1;i--) res[a++] = matrix[r2][i];
                for(int i = r2;i > r1;i--) res[a++] = matrix[i][c1];
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return res;
    }
}
