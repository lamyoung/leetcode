public class MaxSubArray {

	public int maxSubArray(int[] nums) {
		return max(nums);
	}

	public int max(int[] nums) {
		int res = nums[0];
		int maxSide = nums[0];
		for (int i = 1; i < nums.length; i++) {
			maxSide = maxSide < 0 ? nums[i] : maxSide + nums[i];
			res = Math.max(res, maxSide);
		}
		return res;
	}
}
