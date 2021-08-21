package LCNQ;

import java.util.Arrays;
import java.util.HashSet;

public class LC345 {
    public String reverseVowels(String s) {
        char[] charArr = s.toCharArray();
        HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int left = 0, right = charArr.length - 1;
        while(left < right) {
            if(!set.contains(charArr[left])) left++;
            else if(!set.contains(charArr[right])) right--;
            else {
                char tmp = charArr[left];
                charArr[left] = charArr[right];
                charArr[right] = tmp;
                left++;
                right--;
            }
        }
        return new String(charArr);
    }
}
