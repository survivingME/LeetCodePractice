package review;

public class LC725B {
    public int pivotIndex(int[] nums) {
        int sum = 0, lsum = 0, rsum = 0;
        for (int num : nums) {
            sum += num;
        }
        for(int i = 0;i < nums.length;i++) {
            if(i > 0) {
                lsum += nums[i - 1];
            }
            rsum = sum - lsum - nums[i];
            if(lsum == rsum) return i;
        }
        return -1;
    }
}
