package LCNQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0;i < len - 2;i++) {
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = len - 1;
            while(l < r) {
                int sum = -(nums[l] + nums[r]);
                if(nums[i] == sum) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while(l < r && nums[l] == nums[l + 1]) l++;
                    while(l < r && nums[r] == nums[r - 1]) r--;
                }
                if(nums[i] > sum) r--;
                else l++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1,0,1,2,-1,-4};
        new LC15().threeSum(arr);
    }
}
