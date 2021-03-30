package LCNQ;

public class LC74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length, c = matrix[0].length;
        int low = 0, high = r * c - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            int cur = matrix[mid / c][mid % c];
            if(cur == target) return true;
            else if(cur > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
}
