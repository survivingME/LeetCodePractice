package ShopeeTest;

public class LongestUp {
    //1,22,3,5,34,55,33,44,1
    public int[] getLongestUp(int[] nums) {
        int len = nums.length, max = 0;
        int l = 0, r = 1;
        int ml = 0, mr = 0;
        while(r < len) {
            if(nums[r] > nums[r - 1]) r++;
            else {
                int size = r - l;
                if(size > max) {
                    max = size;
                    ml = l;
                    mr = r;
                    l = r;
                }
                r++;
            }
        }
        int[] res = new int[mr - ml];
        int idx = 0;
        for(int i = ml;i < mr;i++) {
            res[idx++] = nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,22,3,5,34,55,33,44,1};
        int[] longestUp = new LongestUp().getLongestUp(nums);
        for (int i : longestUp) {
            System.out.print(i + " ");
        }
    }
}
