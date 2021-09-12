package review;

public class LC34M {
    public int searchRange(int[] nums, int target) {
        int len = nums.length;
        int l = 0, r = len - 1, mid = 0;
        while(l <= r) {
            mid = (l + r) / 2;
            if(nums[mid] == target) break;
            else if(nums[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        if(nums[mid] == target) {
            int li = mid;
            while(li >= 1 && nums[li - 1] == nums[li]) li--;
            return li;
        }
        return -1;
    }
}
