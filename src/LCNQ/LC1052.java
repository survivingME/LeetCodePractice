package LCNQ;

public class LC1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int len = customers.length, sum = 0;
        for(int i = 0;i < len;i++) sum += grumpy[i] == 0 ? customers[i] : 0;
        int inc = 0;
        for(int i = 0;i < X;i++) inc += grumpy[i] * customers[i];
        int maxInc = inc;
        for(int i = 1;i <= len - X;i++) {
            inc -= grumpy[i - 1] * customers[i - 1];
            inc += grumpy[i + X - 1] * customers[i + X - 1];
            maxInc = Math.max(maxInc, inc);
        }
        return sum + maxInc;
    }

    public static void main(String[] args) {
        int[] c = new int[]{1,0,1,2,1,1,7,5};
        int[] a = new int[]{0,1,0,1,0,1,0,1};
        int X = 3;
        System.out.println(new LC1052().maxSatisfied(c, a, X));
    }
}
