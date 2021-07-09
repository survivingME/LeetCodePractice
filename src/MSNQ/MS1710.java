package MSNQ;

public class MS1710 {
    public int majorityElement(int[] nums) {
        int major = nums[0], count = 1;
        for(int i = 1;i < nums.length;i++) {
            if(major == nums[i]) count++;
            else {
                count--;
                if(count == 0) {
                    major = nums[i];
                    count++;
                }
            }
        }
        count = 0;
        for (int num : nums) if(major == num) count++;
        return count > nums.length / 2 ? major : -1;
    }
}
