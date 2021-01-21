public class N0123MaxProfit {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int pre = 0, last = 1;
        int[] profit = new int[2];
        while (last < prices.length) {
            while (last < prices.length - 1 && prices[pre] >= prices[last]) {
                pre++;
                last++;
            }
            if (prices[pre] >= prices[last]) {
                break;
            }
            while (last < prices.length - 1 && prices[last + 1] >= prices[last]) {
                last++;
            }
            int cur = prices[last] - prices[pre];
            if (cur >= profit[1]) {
                profit[0] = profit[1];
                profit[1] = cur;
            } else {
                if (cur > profit[0]) {
                    profit[0] = cur;
                }
            }
            pre = last;
            last++;
        }
        return profit[0] + profit[1];
    }
}
