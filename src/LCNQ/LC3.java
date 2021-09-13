package LCNQ;

import java.util.Arrays;

public class LC3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0, left = 0;
        int[] arr = new int[128];
        Arrays.fill(arr, -1);
        for(int i = 0;i < n;i++) {
            if(arr[s.charAt(i)] != -1) left = Math.max(left, arr[s.charAt(i)] + 1);
            arr[s.charAt(i)] = i;
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}
