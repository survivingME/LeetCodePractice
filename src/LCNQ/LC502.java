package LCNQ;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC502 {
    /**
     * 贪心算法：首先按c升序排序，按w >= c遍历进入大根堆（按p排序），选最大收益
     * @param k
     * @param w
     * @param profits
     * @param capital
     * @return
     */
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int cur = 0;
        int[][] arr = new int[n][2];
        for(int i = 0;i < n;i++) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> que = new PriorityQueue<>((a, b) -> b - a);
        for(int i = 0;i < k;i++) {
            while(cur < n && arr[cur][0] <= w) {
                que.add(arr[cur][1]);
                cur++;
            }
            if(!que.isEmpty()) w += que.poll();
            else return w;
        }
        return w;
    }
}
