package LCNQ;

import java.util.HashMap;
import java.util.HashSet;

public class LC930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        if(sum[sum.length - 1] < goal) return 0;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < sum.length;i++) {
            if(sum[i] == goal) res++;
            if(sum[i] >= goal) res += map.getOrDefault(sum[i] - goal, 0);
            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(new LC930().numSubarraysWithSum(nums, 2));
    }
}
