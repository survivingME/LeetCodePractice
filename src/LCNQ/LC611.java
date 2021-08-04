package LCNQ;

import java.util.Arrays;

public class LC611 {
    /**
     * 双指针 确定i后，双指针从头和尾向中间逼近，记录ans
     * @param nums
     * @return
     */
    public int triangleNumber(int[] nums) {
        if(nums.length < 3) return 0;
        int len = nums.length;
        int ans = 0;
        Arrays.sort(nums);
        for(int i = 0;i < len;i++) {
            for(int j = i - 1, k = 0;k < j;j--) {
                while(k < j && nums[k] + nums[j] <= nums[i]) k++;
                ans += j - k;
            }
        }
        return ans;
    }
}
