package LCNQ;

public class LC714 {
    public int maxProfit(int[] prices, int fee) {
        int d_i_0 = 0, d_i_1 = Integer.MIN_VALUE;
        for (int price : prices) {
            d_i_0 = Integer.max(d_i_0, d_i_1 + price);
            d_i_1 = Integer.max(d_i_1, d_i_0 - price - fee);
        }
        return d_i_0;
    }
}
