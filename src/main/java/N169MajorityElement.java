/**
 * @author lam young
 * @Description
 * @create 2020/6/22 23:38
 */
public class N169MajorityElement {

	public static void main(String[] args) {
		int[] nums = new int[] { 3, 2, 3 };
		majorityElement2(nums);
	}

	public static int majorityElement(int[] nums) {
		int res = nums[0];
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == res) {
				count++;
			} else {
				if (count > 0) {
					count--;
				} else {
					res = nums[i];
					count = 1;
				}
			}
		}
		return res;
	}

	public static int majorityElement2(int[] nums) {
		int count = nums.length / 2;
		int res = 0;
		for (int i = 0; i < 32; i++) {
			int sum = 0;
			for (int num : nums) {
				sum += (num >> i) & 1;
			}
			if (sum > count) {
				res += 1 << i;
			}
		}
		return res;
	}
}
