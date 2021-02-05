package LCNQ;

public class LC424 {
    public int characterReplacement(String s, int k) {
        int[] nums = new int[26];
        int len = s.length();
        char[] arr = s.toCharArray();
        int l = 0, r = 0, max = 0;
        while(r < len) {
            int cur = arr[r] - 'A';
            nums[cur]++;
            max = Math.max(max, nums[cur]);
            if(r - l + 1 - max > k) {
                nums[arr[l] - 'A']--;
                l++;
            }
            r++;
        }
        return r - l;
    }

    public static void main(String[] args) {
        int i = new LC424().characterReplacement("AAAA", 2);
        System.out.println(i);
    }
}
