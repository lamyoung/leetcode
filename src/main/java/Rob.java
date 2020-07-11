public class Rob {

	public int rob(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[1];
		}
		int max1 = nums[0];
		int max2 = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			int tmp = max1;
			max1 = Math.max(max1, max2);
			max2 = tmp + nums[i];
		}
		return Math.max(max1, max2);
	}
}
