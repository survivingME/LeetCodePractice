package newquestion;

public class LC724 {
    public int pivotIndex(int[] nums) {
        if(nums.length == 0) return -1;
        int leftSum = 0, rightSum = 0;
        int len = nums.length;
        for(int i = 1;i < len;i++) rightSum += nums[i];
        if(leftSum == rightSum) return 0;
        for(int i = 1;i < len;i++) {
            leftSum += nums[i - 1];
            rightSum -= nums[i];
            if(leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }
}
