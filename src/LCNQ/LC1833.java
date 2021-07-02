package LCNQ;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC1833 {
    public int maxIceCream(int[] costs, int coins) {
        int ans = 0, sum = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int cost : costs) {
            sum += cost;
            q.add(cost);
            ans++;
            if(sum > coins) {
                sum -= q.poll();
                ans--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] costs = new int[]{1,3,2,4,1,9,20,16,3};
        System.out.println(new LC1833().maxIceCream(costs, 20));
    }
}
