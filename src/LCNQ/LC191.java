package LCNQ;

public class LC191 {
    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new LC191().hammingWeight(-2));
    }
}
