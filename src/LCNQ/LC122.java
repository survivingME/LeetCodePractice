package LCNQ;

public class LC122 {
    public int maxProfit(int[] prices) {
        int dpi0 = 0, dpi1 = -prices[0];
        for(int i = 1;i < prices.length;i++) {
            int tmp = dpi0;
            dpi0 = Math.max(dpi0, dpi1 + prices[i]);
            dpi1 = Math.max(dpi1, tmp - prices[i]);
        }
        return Math.max(dpi0, dpi1);
    }
}
