package LCNQ;

public class LC34 {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1, -1};
        int left = 0, right = nums.length - 1, mid = 0;
        while(left <= right) {
            mid = (left + right) / 2;
            if(nums[mid] == target) break;
            else if(nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        if(nums[mid] == target) {
            int li = mid, ri = mid;
            while(li >= 1 && nums[li - 1] == target) li--;
            while(ri < nums.length - 1 && nums[ri + 1] == target) ri++;
            return new int[]{li, ri};
        }
        return new int[]{-1, -1};
    }
}
