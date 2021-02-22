package LCNQ;

public class LC766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int b = 0, c = 0, a = matrix[b][c];
        while(b < m && c < n) {
            if(a != matrix[b][c]) return false;
            b++;
            c++;
        }
        for(int i = 0;i < m - 1;i++) {
            b = i;
            c = 0;
            a = matrix[b][c];
            while(b < m && c < n) {
                if(a != matrix[b][c]) return false;
                b++;
                c++;
            }
        }
        for(int i = 0;i < n - 1;i++) {
            b = 0;
            c = i;
            a = matrix[b][c];
            while(b < m && c < n) {
                if(a != matrix[b][c]) return false;
                b++;
                c++;
            }
        }
        return true;
    }
}
