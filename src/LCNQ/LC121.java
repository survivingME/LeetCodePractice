package LCNQ;

public class LC121 {
    public int maxProfit(int[] prices) {
        int minPrices = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if(minPrices > price) minPrices = price;
            if(maxProfit < price - minPrices) maxProfit = price - minPrices;
        }
        return maxProfit;
    }
}
