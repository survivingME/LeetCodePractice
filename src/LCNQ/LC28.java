package LCNQ;

import java.util.Locale;

public class LC28 {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()) return 0;
        int n = haystack.length(), m = needle.length();
        String ss = " " + haystack;
        String pp = " " + needle;
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();

        int[] next = new int[m + 1];
        for(int i = 2, j = 0;i <= m;i++) {
            while(j > 0 && p[i] != p[j + 1]) j = next[j];
            if(p[i] == p[j + 1]) j++;
            next[i] = j;
        }

        for(int i = 1, j = 0;i <= n;i++) {
            while(j > 0 && p[i] != p[j + 1]) j = next[j];
            if(s[i] == p[j + 1]) j++;
            if(j == m) return i - m;
        }
        return -1;
    }
}
