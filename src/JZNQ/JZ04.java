package JZNQ;

public class JZ04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int x = 0, y = matrix[0].length - 1;
        while(x < m && y >= 0) {
            if(matrix[x][y] == target) return true;
            else if(matrix[x][y] > target) y--;
            else x++;
        }
        return false;
    }
}
