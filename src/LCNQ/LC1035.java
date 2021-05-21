package LCNQ;

public class LC1035 {
    /**
     * dp[i][j]：s1数组前i位，s2数组前j位，线数量
     * @param nums1
     * @param nums2
     * @return
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1;i <= m;i++) {
            for(int j = 1;j <= n;j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if(nums1[i - 1] == nums2[j - 1]) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2,5,1,2,5};
        int[] nums2 = new int[]{10,5,2,1,5,2};
        int lines = new LC1035().maxUncrossedLines(nums1, nums2);
        System.out.println(lines);
    }
}
