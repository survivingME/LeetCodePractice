package LCNQ;

public class LC81 {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        int start = 0, end = nums.length - 1;
        int mid = start + (end - start) / 2;
        while(start <= end) {
            if(nums[mid] == target) return true;
            if(nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
            } else if(nums[start] <= nums[mid]) {
                if(nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if(nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            mid = start + (end - start) / 2;
        }
        return false;
    }
}
