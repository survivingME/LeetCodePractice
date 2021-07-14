package LCNQ;

import java.util.Arrays;

public class LC1818 {
    int mod = (int)(Math.pow(10, 9) + 7);
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int absSum = 0, max = 0;
        int[] sorted = nums1.clone();
        Arrays.sort(sorted);
        for(int i = 0;i < len;i++) {
            if(nums1[i] == nums2[i]) continue;
            int abs = Math.abs(nums1[i] - nums2[i]);
            absSum += abs;
            int l = 0, r = len - 1;
            while(l < r) {
                int mid = (l + r + 1) / 2;
                if(sorted[mid] <= nums2[i]) l = mid;
                else r = mid - 1;
            }
            int ab = Math.abs(nums2[i] - sorted[l]);
            if(r + 1 < len) ab = Math.min(ab, Math.abs(nums2[i] - sorted[r + 1]));
            if(ab < abs) max = Math.max(max, abs - ab);
        }
        return (absSum - max) % mod;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,10,4,4,2,7};
        int[] nums2 = new int[]{9,3,5,1,7,4};
        System.out.println(new LC1818().minAbsoluteSumDiff(nums1, nums2));
    }
}
