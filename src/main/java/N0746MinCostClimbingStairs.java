public class N0746MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        if (cost.length == 1) {
            return cost[0];
        }
        int res[] = new int[cost.length];
        res[0] = cost[0];
        res[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            res[i] = Math.min(res[i - 2], res[i - 1]) + cost[i];
        }
        return Math.min(res[res.length - 1], res[res.length - 2]);
    }
}
