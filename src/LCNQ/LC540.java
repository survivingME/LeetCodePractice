package LCNQ;

public class LC540 {
    public int singleNonDuplicate(int[] nums) {
        int s = 0, e = nums.length - 1;
        while(s < e) {
            int mid = (s + e) / 2;
            if(mid % 2 == 1) mid--;
            if(nums[mid] == nums[mid + 1]) s = mid + 2;
            else e = mid;
        }
        return nums[s];
    }
}
