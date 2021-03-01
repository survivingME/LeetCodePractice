package LCNQ;

public class LC303 {
    class NumArray {
        int[] arr;
        public NumArray(int[] nums) {
            int len = nums.length;
            if(len == 0) return;
            arr = new int[len];
            arr[0] = nums[0];
            for(int i = 1;i < len;i++) arr[i] = arr[i - 1] + nums[i];
        }

        public int sumRange(int i, int j) {
            if(i == 0) return arr[j];
            else return arr[j] - arr[i - 1];
        }
    }
}
