package LCNQ;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC1738 {
    /**
     * xorSum[i][j] = xorSum[i - 1][j] ^ xorSum[i][j - 1] ^ xorSum[i - 1][j - 1] ^ matrix[i - 1][j - 1]
     * @param matrix
     * @param k
     * @return
     */
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] xorSum = new int[m + 1][n + 1];
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.comparingInt(o -> o));
        for(int i = 1;i <= m;i++) {
            for(int j = 1;j <= n;j++) {
                xorSum[i][j] = xorSum[i - 1][j] ^ xorSum[i][j - 1] ^ xorSum[i - 1][j - 1] ^ matrix[i - 1][j - 1];
                if(queue.size() < k) queue.add(xorSum[i][j]);
                else {
                    if(xorSum[i][j] > queue.peek()) {
                        queue.poll();
                        queue.add(xorSum[i][j]);
                    }
                }
            }
        }
        return queue.peek();
    }

}
