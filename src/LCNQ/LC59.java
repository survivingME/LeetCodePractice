package LCNQ;

public class LC59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int r1 = 0, r2 = n - 1;
        int c1 = 0, c2 = n - 1;
        int cur = 1;
        while(r1 <= r2 && c1 <= c2) {
            for(int i = c1;i <= c2;i++) res[r1][i] = cur++;
            for(int i = r1 + 1;i <= r2;i++) res[i][c2] = cur++;
            if(r1 < r2 && c1 < c2) {
                for(int i = c2 - 1;i >= c1;i--) res[r2][i] = cur++;
                for(int i = r2 - 1;i > r1;i--) res[i][c1] = cur++;
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new LC59().generateMatrix(4);
        for(int i = 0;i < matrix.length;i++) {
            for(int j = 0;j < matrix[i].length;j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
