package LCNQ;

public class LC402 {
    public String removeKdigits(String num, int k) {
        if(k > num.length()) return "0";
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < num.length();i++) {
            while(sb.length() > 0 && k > 0 && sb.charAt(sb.length() - 1) > num.charAt(i)) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(num.charAt(i));
        }
        while(sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        for(int i = 0;i < k;i++) sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
