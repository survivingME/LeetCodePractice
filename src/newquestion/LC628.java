package newquestion;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC628 {
    public int maximumProduct(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int res1 = nums[len - 1] * nums[len - 2] * nums[len - 3];
        if(len == 3) return res1;
        if(nums[1] < 0) {
            int res2 = nums[0] * nums[1] * nums[len - 1];
            res1 = Math.max(res1, res2);
        }
        return res1;
    }
}
