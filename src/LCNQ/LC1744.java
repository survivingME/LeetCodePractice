package LCNQ;

public class LC1744 {
    /**
     * 计算前缀和
     * @param candiesCount
     * @param queries
     * @return
     */
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int len = candiesCount.length;
        long[] sum = new long[len];
        sum[0] = candiesCount[0];
        for(int i = 1;i < len;i++) sum[i] = sum[i - 1] + candiesCount[i];
        int rLen= queries.length;
        boolean[] res = new boolean[rLen];
        for(int i = 0;i < rLen;i++) {
            long x1 = queries[i][1] + 1;
            long y1 = (long) (queries[i][1] + 1) * queries[i][2];
            long x2 = queries[i][0] == 0 ? 1 : sum[queries[i][0] - 1] + 1;
            long y2 = sum[queries[i][0]];

            res[i] = !(x1 > y2 || y1 < x2);
        }
        return res;
    }
}
