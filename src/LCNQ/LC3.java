package LCNQ;

import java.util.Arrays;

public class LC3 {
    public int lengthOfLongestSubstring(String s) {
        int[] index = new int[128];
        Arrays.fill(index, -1);
        int left = 0, ans = 0;
        for(int i = 0;i < s.length();i++) {
            if(index[s.charAt(i)] != -1) left = Math.max(left, index[s.charAt(i)] + 1);
            index[s.charAt(i)] = i;
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}
