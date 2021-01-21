public class N0122MaxProfit_2 {

    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int[][] profit = new int[2][prices.length];
        profit[0][0] = 0;
        profit[1][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            profit[0][i] = Math.max(profit[0][i - 1], profit[1][i - 1] + prices[i] - fee);
            profit[1][i] = Math.max(profit[0][i - 1] - prices[i], profit[1][i - 1]);
        }
        return profit[0][prices.length-1];
    }

    public static void main(String[] args) {
        int[] prices= new int[]{1,3,7,5,10,3};
        N0122MaxProfit_2 m = new N0122MaxProfit_2();
        System.out.println(m.maxProfit(prices,3));
    }
}
