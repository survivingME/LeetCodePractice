package LCNQ;

public class LC1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] num = new int[100];
        int res = 0;
        for (int[] dominoe : dominoes) {
            int val = dominoe[0] < dominoe[1] ? dominoe[0] * 10 + dominoe[1] : dominoe[1] * 10 + dominoe[0];
            res += num[val];
            num[val]++;
        }
        return res;
    }
}
