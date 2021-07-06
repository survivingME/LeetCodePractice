package NKNQ;

public class StringCalculation {
    int len, curIdx = 0;
    String str;
    public String computeString (String str) {
        len = str.length();
        this.str = str;
        return compute(1);
    }

    public String compute(int k) {
        StringBuilder sb1 = new StringBuilder();
        int nextK = 0;
        while(curIdx < len) {
            char cur = str.charAt(curIdx);
            if(cur == ']') {
                StringBuilder sb2 = new StringBuilder(sb1);
                for(int i = 0;i < k - 1;i++) {
                    sb1.append(sb2);
                }
                return sb1.toString();
            } else if(cur == '[') {
                curIdx++;
                sb1.append(compute(nextK == 0 ? 1 : nextK));
            } else if(Character.isDigit(cur)) {
                nextK = nextK * 10 + cur - '0';
            } else if(cur != '*') {
                sb1.append(cur);
            }
            curIdx++;
        }
        return sb1.toString();
    }

    public static void main(String[] args) {
        String str = "3*[a2*[c]]";
        String s = new StringCalculation().computeString(str);
        System.out.println(s);
    }
}
