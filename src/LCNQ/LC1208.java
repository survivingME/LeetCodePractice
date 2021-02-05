package LCNQ;

public class LC1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();
        int[] arr = new int[len];
        for(int i = 0;i < len;i++) {
            arr[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int start = 0, end = 0, sum = 0, res = 0;
        while(end < len) {
            if(sum + arr[end] <= maxCost) {
                sum += arr[end++];
            } else {
                if(end > start) {
                    res = Math.max(res, end - start);
                    sum -= arr[start++];
                } else {
                    start++;
                    end = start;
                }
            }
        }
        res = Math.max(res, end - start);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LC1208().equalSubstring("krpgjbjjznpzdfy","nxargkbydxmsgby",14));
    }
}
