/**
 * @author lam young
 * @Description
 * @create 2020/5/21 8:55
 */
public class RemoveDuplicates {

	public static void main(String[] args) {
		int[] nums = new int[]{0,1,2,2,3,0,4,2};
		int res = removeElement(nums, 2);
		System.out.println(res);
	}

	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return 1;
		}
		int i = 0, j = 1;
		for (; j < nums.length; j++) {
			if (nums[j] == nums[i]) {
				continue;
			} else {
				i++;
				nums[i] = nums[j];
			}
		}
		return i+1;
	}

	public static int removeElement(int[] nums, int val) {
		if (nums.length == 0) {
			return 0;
		}
		int i = 0, j = 0;
		for (; j < nums.length; j++) {
			if (nums[j] == val) {
				continue;
			} else {
				if(i!=j) {
					nums[i] = nums[j];
				}
				i++;
			}
		}
		return i;
	}
}
