package LCNQ;

public class LC566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        if(m == 0 && r == 0) return nums;
        int n = nums[0].length;
        if(m * n != r * c) return nums;
        int[][] nnums = new int[r][c];
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                int idx = i * n + j;
                nnums[idx / c][idx % c] = nums[i][j];
            }
        }
        return nnums;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,2}, {3,4}};
        new LC566().matrixReshape(nums, 1, 4);
    }
}
