package LCNQ;

public class LC1486 {
    public int xorOperation(int n, int start) {
        int res = start;
        for(int i = 1;i < n;i++) {
            int cur = start + 2 * i;
            res ^= cur;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LC1486().xorOperation(1, 7));
    }
}
