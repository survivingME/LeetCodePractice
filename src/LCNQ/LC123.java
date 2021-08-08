package LCNQ;

public class LC123 {
    public int maxProfit(int[] prices) {
        int dp10 = 0, dp11 = Integer.MIN_VALUE;
        int dp20 = 0, dp21 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp20 = Math.max(dp20, dp21 + price);
            dp21 = Math.max(dp21, dp10 - price);
            dp10 = Math.max(dp10, dp11 + price);
            dp11 = Math.max(dp11, -price);
        }
        return dp20;
    }
}
