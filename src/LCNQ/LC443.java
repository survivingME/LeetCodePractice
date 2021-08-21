package LCNQ;

public class LC443 {
    public int compress(char[] chars) {
        char[] modi = new char[chars.length];
        int cur = 0;
        int res = 0;
        int i;
        int count = 1;
        for(i = 0;i < chars.length;i++) {
            if(i > 0) {
                if(chars[i] == chars[i - 1]) count++;
                else {
                    modi[cur++] = chars[i - 1];
                    if(count > 1) {
                        String countStr = String.valueOf(count);
                        int j = 0;
                        while(j < countStr.length()) {
                            modi[cur++] = countStr.charAt(j++);
                            res++;
                        }
                    }
                    res += 1;
                    count = 1;
                }
            }
        }
        modi[cur++] = chars[i - 1];
        if(count > 1)  {
            String countStr = String.valueOf(count);
            int j = 0;
            while(j < countStr.length()) {
                modi[cur++] = countStr.charAt(j++);
                res++;
            }
        }
        res += 1;
        for(i = 0;i < modi.length;i++) chars[i] = modi[i];
        return res;
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'b', 'b','b', 'b', 'b', 'b', 'b'};
        System.out.println(new LC443().compress(chars));
        for (char aChar : chars) {
            System.out.print(aChar + " ");
        }
    }
}
