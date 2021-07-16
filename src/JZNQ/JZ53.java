package JZNQ;

public class JZ53 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int l = 0, r = len - 1;
        while(l < r) {
            int mid = (l + r) / 2;
            if(nums[mid] == target) {
                int li = mid, ri = mid;
                while(li > 0 && nums[li - 1] == nums[li]) li--;
                while(ri < len && nums[ri + 1] == nums[ri]) ri++;
                return ri - li + 1;
            } else if(nums[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        return 0;
    }
}
