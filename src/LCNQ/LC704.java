package LCNQ;

public class LC704 {
    public int search(int[] nums, int target) {
        if(target < nums[0] || target > nums[nums.length - 1]) return -1;
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int mid = (l + r) / 2;
            if(nums[mid] == target) return mid;
            else if(target > nums[mid]) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1,0,3,5,9,12};
        int search = new LC704().search(arr, 9);
    }
}
