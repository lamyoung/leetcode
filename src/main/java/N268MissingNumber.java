/**
 * @author lam young
 * @Description
 * @create 2020/7/7 23:59
 */
public class N268MissingNumber {

	public static int missingNumber(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			nums[i] += 1;
		}
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i])-1;
			if (index < nums.length) {
				nums[index] = -nums[index];
			}
		}
		System.out.println("aaa");
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				return i;
			}
		}
		return nums.length;
	}

	public static int missingNumber2(int[] nums) {
		int res = nums.length;
		for (int i = 0; i < nums.length; i++) {
			res ^= nums[i];
			res ^= i;
		}
		return res;
	}

	public static void main(String[] args) {
		int[] test = new int[] { 9,6,4,2,3,5,7,0,1 };
		System.out.println(missingNumber(test));
	}
}
