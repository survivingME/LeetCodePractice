package LCNQ;

public class LC342 {
    /**
     * 4^x = (3 + 1) ^ x = 1 (mod 3)
     * 如果是2的幂，可以表示为4 ^ x * 2的形式，mod 3 结果为2
     * @param n
     * @return
     */
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && n % 3 == 1;
    }

    public static void main(String[] args) {
        new LC342().isPowerOfFour(16);
    }
}
