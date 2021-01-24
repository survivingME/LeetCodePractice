public class LC647 {
    public int findLengthOfLCIS(int[] nums) {
        int res = 1;
        int i = 1, len = nums.length;
        //注意numns长度为0的case
        if(len == 0) return 0;
        if(len < 2) return res;
        while(i < len) {
            int cur = 1;
            while(i < len && nums[i] > nums[i - 1]) {
                i++;
                cur++;
            }
            res = Math.max(res, cur);
            while(i < len && nums[i] <= nums[i - 1]) i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,4,7};
        System.out.println(new LC647().findLengthOfLCIS(nums));
    }
}
