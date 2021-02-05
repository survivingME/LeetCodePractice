package JZNQ;

public class JZ03 {
    public int findRepeatNumber(int[] nums) {
        int len = nums.length;
        for(int i = 0;i < len;i++) {
            while(nums[i] != i) {
                if(nums[nums[i]] != nums[i]) {
                    int temp = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = temp;
                } else {
                    return nums[i];
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new JZ03().findRepeatNumber(new int[]{2,3,1,0,2,5,3}));
    }
}
