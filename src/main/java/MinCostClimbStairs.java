public class MinCostClimbStairs {

	public int minCostClimbingStairs(int[] cost) {
		int length = cost.length;
		// 到达第零台阶需要花费
		int one = 0;
		// 到达第一台阶需要花费
		int two = 0;
		for(int i=2; i<=length; i++) {
			int tmpOne = two;
			two = Math.min(one+cost[i-2], two+cost[i-1]);
			one = tmpOne;
		}
		return two;
	}
}
