package LCNQ;

public class LC88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int s1 = m - 1, s2 = n - 1;
        int cur, tail = m + n - 1;
        while(s1 >= 0 && s2 >= 0) {
            if(nums1[s1] >= nums2[s2]) cur = nums1[s1--];
            else cur = nums2[s2--];
            nums1[tail--] = cur;
        }
        while(s2 >= 0) nums1[tail--] = nums2[s2--];
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3,7,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        new LC88().merge(nums1, 3, nums2, 3);
        for (int i : nums1) {
            System.out.print(i + " ");
        }
    }
}
