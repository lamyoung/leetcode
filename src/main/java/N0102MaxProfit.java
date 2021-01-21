public class N0102MaxProfit {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxPrices = prices[prices.length - 1];
        int maxProfit = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            if (prices[i] < maxPrices) {
                maxProfit = Math.max(maxProfit, maxPrices - prices[i]);
            }
            if (maxPrices < prices[i]) {
                maxPrices = prices[i];
            }
        }
        return maxProfit;
    }
}
