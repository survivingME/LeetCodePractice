package LCNQ;

public class LC80 {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int l = 0, r = 0;
        while(r < len) {
            if(r < len - 1) {
                if(nums[r] != nums[r + 1]) {
                    if(r - l > 1) {
                        int startd = l + 2, starts = r + 1;
                        while(starts < len) nums[startd++] = nums[starts++];
                        len -= r - l - 1;
                        r = l + 2;
                        l = r;
                    } else {
                        r++;
                        l = r;
                    }
                } else {
                    r++;
                }
            } else {
                if(r - l > 1) {
                    int startd = l + 2, starts = r + 1;
                    while(starts < len) nums[startd++] = nums[starts++];
                    len -= r - l - 1;
                    r = l + 2;
                    l = r;
                } else {
                    r++;
                }
            }
        }
        return len;
    }

    public int rd(int[] nums) {
        if(nums.length<2) return nums.length;
        int index = 2;
        for(int i=2;i<nums.length;i++){
            if(nums[index-2]!=nums[i]){
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        int len = new LC80().rd(nums);
        System.out.println(len);
    }
}
