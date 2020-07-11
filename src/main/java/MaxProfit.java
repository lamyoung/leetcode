public class MaxProfit {

	// 只买卖一次
	public int maxProfit(int[] prices) {
		if (prices.length == 1) {
			return 0;
		}
		int min = prices[0];
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < prices.length; i++) {

			if (prices[i] > min) {
				max = Math.max(max, prices[i] - min);
			}
			min = Math.min(min, prices[i]);
		}
		return max > 0 ? max : 0;
	}

	// 可买卖多次
	public int maxProfitMore(int[] prices) {
		int benefit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				benefit += prices[i] - prices[i - 1];
			}
		}
		return benefit;
	}
}
