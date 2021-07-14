package LCNQ;

import java.util.Arrays;
import java.util.Comparator;

public class LC179 {
    public String largestNumber(int[] nums) {
        int len = nums.length;
        String[] numsStr = new String[len];
        for(int i = 0;i < len;i++) numsStr[i] = "" + nums[i];
        Arrays.sort(numsStr, (o1, o2) -> {
            String a = o1 + o2, b = o2 + o1;
            return b.compareTo(a);
        });
        StringBuilder sb = new StringBuilder();
        for (String s : numsStr) sb.append(s);
        int l = 0;
        while(l < sb.length() - 1 && sb.charAt(l) == '0') l++;
        return sb.substring(l);
    }
}
