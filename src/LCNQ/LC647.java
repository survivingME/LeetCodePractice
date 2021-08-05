package LCNQ;

public class LC647 {
    public int countSubstrings(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        int res = 0;
        for(int i = 0;i < len;i++) {
            for(int j = 0;j <= 1;j++) {
                int l = i, r = i + j;
                while(l >= 0 && r < len && charArray[l--] == charArray[r++]) res++;
            }
        }
        return res;
    }
}
